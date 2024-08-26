package com.cpena.contactos.back.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cpena.contactos.back.services.exceptions.BusinessException;
import com.cpena.contactos.back.services.exceptions.ContactosError;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ResponseBody
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ContactosError> exceptionHandler( ValidationException e ){
		return new ResponseEntity<>(new ContactosError(e.getMessage()), HttpStatus.BAD_REQUEST);
		
	}
	
	@ResponseBody
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ContactosError> exceptionHandler(ConstraintViolationException e){		
		return new ResponseEntity<>(new ContactosError(e.getMessage()), HttpStatus.BAD_REQUEST);
		
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, List<String>>> exceptionHandler( MethodArgumentNotValidException e ){
		log.error("MethodArgumentNotValidException: " + e.getMessage() + "\n" + HttpStatus.BAD_REQUEST);
//		fuente: https://salithachathuranga94.medium.com/validation-and-exception-handling-in-spring-boot-51597b580ffd
		List<String> errors = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(FieldError::getDefaultMessage)
				.collect(Collectors.toList());
				
		return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);		
	}
	
		
	@ResponseBody
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ContactosError> exceptionHandler(BusinessException e){
		return new ResponseEntity<>(e.getError(), e.getStatusCode());
	}
	
	
	private Map<String, List<String>> getErrorsMap(List<String> errors){
		Map<String, List<String>> errorResponse = new HashMap<>();
		errorResponse.put("errors", errors);
		return errorResponse;
	}
	
	

}
