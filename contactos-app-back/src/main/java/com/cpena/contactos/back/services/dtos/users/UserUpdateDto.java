package com.cpena.contactos.back.services.dtos.users;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class UserUpdateDto {

//	@NotEmpty(message = "{user.id.notempty}")
//	@Pattern(regexp = "^-?\\d{1,19}$")
	private Long id;
	
	@NotEmpty(message = "{email.notempty}")
	@Size(min = 2, max = 100, message = "user.name.size")
	private String name;
	
	@NotEmpty(message = "{user.lastname.notempty}")
	@Size(min = 2, max= 100, message = "{lastname.notmepty}")
	private String lastname;
	
	@NotEmpty(message = "{user.email.notempty}")
	@Email( message = "{email.notvalidpattern}", 
			regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	private String email;
	
	@NotEmpty(message = "{user.password.notempty}")
	@Size(min = 6, max = 15, message = "{user.password.size}")
	private String password;
	
//	@NotEmpty(message = "{user.isactive.notempty}")
//	@Range(min = 1, max = 1, message = "{user.isactive.size}")
	private Boolean isActive;
	

}
