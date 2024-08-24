package com.cpena.contactos.back.services.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import com.cpena.contactos.back.constants.ErrorMessageEnum;

import lombok.Getter;

@Getter
public class BusinessException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	private final transient ContactosError error;
	
	public BusinessException(HttpStatusCode status, String reason) {
		super(status, reason);
		this.error = new ContactosError(reason);
	}
	
	public BusinessException(HttpStatusCode status, String reason, Throwable cause) {
		super(status, reason, cause);
		this.error = new ContactosError(reason);
	}
	
	public BusinessException( HttpStatusCode status, ErrorMessageEnum error ) {
		super(status, error.getMessage());
		this.error = new ContactosError(error.getMessage(), error.getCode());
		
	}
	
		
	public BusinessException( HttpStatusCode status, ErrorMessageEnum error, Throwable cause ) {
		super(status, error.getMessage(), cause);
		this.error = new ContactosError(error.getMessage(), error.getCode());
		
	}






}
