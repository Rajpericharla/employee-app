package com.lendage.employee.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorMessage {
	private HttpStatus errorCode;
	private String errorMessage;
}
