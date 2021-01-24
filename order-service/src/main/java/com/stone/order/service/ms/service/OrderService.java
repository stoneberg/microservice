package com.stone.order.service.ms.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.stone.order.service.ms.common.exception.TransactionExType;
import com.stone.order.service.ms.common.exception.TransactionException;
import com.stone.order.service.ms.dto.TransactionDto.OrderDto;
import com.stone.order.service.ms.dto.TransactionDto.PaymentDto;
import com.stone.order.service.ms.dto.TransactionDto.RequestDto;
import com.stone.order.service.ms.dto.TransactionDto.ResponseDto;
import com.stone.order.service.ms.entity.Order;
import com.stone.order.service.ms.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;
    
    /**
     * Save Order And Payment Transaction
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto saveOrder(RequestDto requestDto) {
        OrderDto orderDto = requestDto.getOrder();
        Order order = Order.builder()
                .name(orderDto.getName())
                .qty(orderDto.getQty())
                .price(orderDto.getPrice())
                .build();
        
        orderRepository.saveAndFlush(order);
        
        PaymentDto paymentDto = requestDto.getPayment();
        paymentDto.setOrderId(order.getId());
        paymentDto.setPayment(order.getPrice() * order.getQty());
        
        ResponseEntity<PaymentDto> responseEntity = null;
        
        // do a rest call to payment and pass the order id
        try {
        	responseEntity  = restTemplate.postForEntity("http://PAYMENT-SERVICE/v1/api/payment-service/payment", paymentDto, PaymentDto.class);
        	//responseEntity  = restTemplate.postForEntity("http://localhost:9192/v1/api/payment-service/payment", paymentDto, PaymentDto.class);
		} catch (Exception e) {
			throw new TransactionException(TransactionExType.PAYMENT_FAIL);
		}
        
        // result response
        ResponseDto responseDto = new ResponseDto();
        orderDto.setId(order.getId());
        responseDto.setOrder(orderDto);
        responseDto.setPayment(responseEntity.getBody());
        
        return responseDto;
                
    }

}
