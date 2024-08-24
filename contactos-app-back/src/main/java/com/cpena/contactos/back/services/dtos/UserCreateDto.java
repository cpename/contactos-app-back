package com.cpena.contactos.back.services.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Object Dto for the creation of an User.
 * It has just the properties necesary name, lastname, email and password. 
 * @author capem76
 */
@Data
@RequiredArgsConstructor
public class UserCreateDto {
	
	@NotEmpty
	@Size(min = 2, max = 100, message = "{email.notempty}")
	private String name;
	
	private String lastName;
	
	private String email;
		
	private String password;
	
	
}
