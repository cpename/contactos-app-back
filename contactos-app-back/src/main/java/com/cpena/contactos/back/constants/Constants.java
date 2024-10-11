package com.cpena.contactos.back.constants;

public class Constants {
	
	public static final String BASE_URI = "/contacts/api";
	
//	Security Constants
	//Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
	public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)";
	
	//7200000 milliseconds = 7200 seconds = 2 hours.	
	public static final int TOKEN_EXPIRATION = 7200000;
	
	// Authorization : "Bearer " + Token 
	public static final String BEARER = "Bearer";
	
	// "Authorization" : Bearer Token
	public static final String AUTHORIZATION = "Authorization";
	
	// Public path that clients can use to register.
	public static final String REGISTER_PATH = BASE_URI + "/user/register";

}
