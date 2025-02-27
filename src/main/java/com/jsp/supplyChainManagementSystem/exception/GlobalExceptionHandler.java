package com.jsp.supplyChainManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handlerIdNotFoundException(IdNotFoundException exception){
		ResponceStructure<String> structure = new ResponceStructure<String>();
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Not Found");
		structure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.OK);
	}
	
}
