package com.cpena.contactos.back.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorMessageEnum {
//	user creating
	USER_EMAIL_ALREADY_EXIST("USER_T01", "Email already exist"),
	USER_NAME_LASTNAME("USER_T02", "User name and lastname already exist"),
	USER_NOT_FOUND("USER_T03", "The requested user is not found"),
	
//	profile creating
	PROFILE_NAME_ALREADY_EXIST("", ""),
	PROFILE_NAME_NOT_FOUND("", "");

	private final String code;
	private final String message;
	
	

}
