package com.cpena.contactos.back.constants;

public class Constants {
	
	public static final String BASE_URI = "/contacts/api";
	
//	Security Constants
	//Your secret should always be strong (uppercase, lowercase, numbers, symbols) so that nobody can potentially decode the signature.
//	public static final String SECRET_KEY = "bQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)";
	public static final String SECRET_KEY = "bd19ac19a6bf0ca2f8ac65a4079b2c3b5d5ebf331646d7fdec08a6d4907ee25fcfb5598f0dbf13c30cdb3e53e596b4b33386e4eb29128fe04de091264e29c080";
	
	
	//7200000 milliseconds = 7200 seconds = 2 hours.	
	public static final int TOKEN_EXPIRATION_120_MINUTES =7200000;
	
	public static final int TOKEN_EXPIRATION_30_MINUTES =1800000;
	
	// Authorization : "Bearer " + Token 
	public static final String BEARER = "Bearer ";
	
	// "Authorization" : Bearer Token
	public static final String AUTHORIZATION = "Authorization";
	
	// Public path that clients can use to register.
	public static final String REGISTER_PATH = BASE_URI + "/users/register";

}
