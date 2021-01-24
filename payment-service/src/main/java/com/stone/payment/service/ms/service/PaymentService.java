package com.stone.payment.service.ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stone.payment.service.ms.common.exception.TransactionExType;
import com.stone.payment.service.ms.common.exception.TransactionException;
import com.stone.payment.service.ms.dto.TransactionDto.PaymentDto;
import com.stone.payment.service.ms.entity.Payment;
import com.stone.payment.service.ms.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PaymentService {
    
    private final PaymentRepository paymentRepository;
    
    /**
     * save payment
     * @param paymentDto
     * @return
     */
    @Transactional
    public PaymentDto savePayment(PaymentDto paymentDto) {
        
        // String status = this.paymentProcessing();
        String status = "success";
        
        Payment payment = Payment.builder()
                .paymentStatus(status)
                .transactionId(UUID.randomUUID().toString())
                .payment(paymentDto.getPayment())
                .orderId(paymentDto.getOrderId())
                .build();
        
        paymentRepository.save(payment);
        
        if (status.equals("failed")) {
            throw new TransactionException(TransactionExType.PAYMENT_FAIL);
        }
        
        paymentDto.setId(payment.getPaymentId());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());
        paymentDto.setTransactionId(payment.getTransactionId());
        
        return paymentDto;
        
    }
    
    // 3rd party payment gateway
    private String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "failed";
    }
    
    /**
     * get all payment list
     * @return
     */
    public List<PaymentDto> findPayment() {
    	List<Payment> payments = paymentRepository.findAll();
    	List<PaymentDto> paymentDtos = new ArrayList<>();
    	
    	payments.forEach(payment -> {
    		PaymentDto paymentDto = new PaymentDto();
    		paymentDto.setId(payment.getPaymentId());
    		paymentDto.setPaymentStatus(payment.getPaymentStatus());
    		paymentDto.setTransactionId(payment.getTransactionId());
    		paymentDto.setOrderId(payment.getOrderId());
    		paymentDto.setPayment(payment.getPayment());
    		paymentDtos.add(paymentDto);
    	});
    	
    	return paymentDtos;
    	
    }

}
