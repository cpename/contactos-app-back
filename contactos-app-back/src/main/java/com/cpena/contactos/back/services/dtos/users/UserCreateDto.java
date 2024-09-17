package com.cpena.contactos.back.services.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Object Dto for the creation of an User.
 * It has just the properties necesary name, lastname, email and password. 
 * @author capem76
 */
@Data
@RequiredArgsConstructor
public class UserCreateDto {
	
	@NotEmpty(message = "{user.name.notempty}")
	@Size(min = 2, max = 100, message = "{user.name.size}")
	private String name;
	
	@NotEmpty(message = "{user.lastname.notempty}")
	@Size(min = 2, max= 100, message = "{user.lastname.size}")
	private String lastname;
	
	@NotEmpty(message = "{user.email.notempty}")
	@Email( message = "{user.email.notvalidpattern}", 
			regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	private String email;
	
	@NotEmpty(message = "{user.password.notempty}")
	@Size(min = 6, max = 15, message = "{user.password.size}")
	private String password;
	
	
}
