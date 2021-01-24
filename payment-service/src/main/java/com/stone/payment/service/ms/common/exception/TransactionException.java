package com.stone.payment.service.ms.common.exception;

import lombok.Getter;

public class TransactionException extends RuntimeException {
	private static final long serialVersionUID = 4698980797856410517L;

	@Getter
	private final BaseExceptionType exceptionType;

	public TransactionException(BaseExceptionType exceptionType) {
		super(exceptionType.getMessage());
		this.exceptionType = exceptionType;
	}
}
