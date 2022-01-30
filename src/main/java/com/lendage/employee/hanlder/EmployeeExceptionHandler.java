package com.lendage.employee.hanlder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lendage.employee.model.ErrorDetails;
import com.lendage.employee.model.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(basePackages = { "com.lendage.employee" })
@Slf4j
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public final ResponseEntity<ErrorMessage> handleException(Exception exception) {
		log.error(exception.toString());
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
		errorMessage.setErrorMessage(exception.getMessage());
		return ResponseEntity.badRequest().body(errorMessage);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errorList = ex.getBindingResult().getFieldErrors().stream()
				.map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
		ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errorList);
		return handleExceptionInternal(ex, errorDetails, headers, errorDetails.getStatus(), request);
	}

}
