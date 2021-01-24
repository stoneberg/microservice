package com.stone.order.service.ms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.order.service.ms.common.dto.ResponseTemplate;
import com.stone.order.service.ms.dto.TransactionDto.RequestDto;
import com.stone.order.service.ms.dto.TransactionDto.ResponseDto;
import com.stone.order.service.ms.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/order-service")
public class OrderApiController {
	
	private final OrderService orderService;
	
	@PostMapping("/order")
	public ResponseTemplate<?> order(@RequestBody RequestDto requestDto) {
		ResponseDto responseDto = orderService.saveOrder(requestDto);
		return ResponseTemplate.ok(responseDto);
	}

}
