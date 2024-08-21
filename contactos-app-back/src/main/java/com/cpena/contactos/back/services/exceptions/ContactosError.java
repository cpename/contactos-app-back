package com.cpena.contactos.back.services.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactosError {
		
	private String errorMessage;
	private String errorCode;
	
	
	
	public ContactosError(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}


	public ContactosError(String errorMessage, String errorCode) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}
	
	

}
