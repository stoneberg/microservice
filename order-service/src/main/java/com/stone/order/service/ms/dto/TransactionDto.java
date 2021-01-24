package com.stone.order.service.ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TransactionDto {

	private TransactionDto() {
		throw new IllegalStateException("Dto Wrapper Class");
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class RequestDto {
		private OrderDto order;
		private PaymentDto payment;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class OrderDto {
		private Integer id;
		private String name;
		private Integer qty;
		private Double price;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PaymentDto {
		private Integer id;
		private String paymentStatus;
		private String transactionId;
		private Integer orderId;
		private Double payment;
	}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class ResponseDto {
		private OrderDto order;
		private PaymentDto payment;
	}

}
