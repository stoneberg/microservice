package com.stone.payment.service.ms.common.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    private HttpStatus status;
    private String message;
}
