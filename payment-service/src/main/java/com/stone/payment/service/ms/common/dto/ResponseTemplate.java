package com.stone.payment.service.ms.common.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate<T> extends BaseResponse {

	private T data;

	public static <T> ResponseTemplate<T> ok(T data) {
		ResponseTemplate<T> response = new ResponseTemplate<>();
		response.setData(data);
		response.setMessage("success");
		response.setStatus(HttpStatus.OK);
		return response;
	}
	
}

