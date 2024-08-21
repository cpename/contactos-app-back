package com.cpena.contactos.back.services.exceptions;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class ContactosException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public ContactosException(HttpStatusCode status) {
		super(status);
		// TODO Auto-generated constructor stub
	}

}
