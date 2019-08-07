package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<com.example.demo.Error> handleException(Exception e) {
		com.example.demo.Error error=new com.example.demo.Error();
		error.setCode(HttpStatus.BAD_REQUEST.toString());
		error.setMessage(e.getMessage());
		return new ResponseEntity<com.example.demo.Error>(error, HttpStatus.BAD_REQUEST);
	}
}