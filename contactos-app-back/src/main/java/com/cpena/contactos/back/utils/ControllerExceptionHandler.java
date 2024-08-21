package com.cpena.contactos.back.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpena.contactos.back.services.exceptions.BusinessException;
import com.cpena.contactos.back.services.exceptions.ContactosError;


import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(ValidationException.class)
	ResponseEntity<ContactosError> exceptionHandler( ValidationException e ){
		return new ResponseEntity<>(new ContactosError(e.getMessage()), HttpStatus.BAD_REQUEST);
		
	}
	
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<ContactosError> exceptionandler(ConstraintViolationException e){
		return new ResponseEntity<>(new ContactosError(e.getMessage()), HttpStatus.BAD_REQUEST);
		
	}
	
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	ResponseEntity<ContactosError> exceptionHandler(BusinessException e){
		return new ResponseEntity<>(e.getError(), e.getStatusCode());
	}
	
	

}
