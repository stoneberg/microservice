package com.stone.payment.service.ms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stone.payment.service.ms.dto.TransactionDto.PaymentDto;
import com.stone.payment.service.ms.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/payment-service")
public class PaymentController {
	
	private final PaymentService paymentService;
	
	@PostMapping("/payment")
	public ResponseEntity<?> pay(@RequestBody PaymentDto paymentDto) {
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.savePayment(paymentDto));
	}
	
	@GetMapping("/payment")
	public ResponseEntity<?> getPayment() {
		return ResponseEntity.status(HttpStatus.OK).body(paymentService.findPayment());
	}
	
}
