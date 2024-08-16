package com.cpena.contactos.back.services.dtos;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	
	@NotEmpty(message = "the name must be not null or empty")
	private String name;
	
	@NotEmpty(message = "lastname must be not null or empty")
	private String lastname;
		
	@Email(message = "email must be in a correct format")
	private String email;
	
	@Size(max = 15, min = 6, message = "Password must be between 6 and 15 character length")
	private String password;
	
	private Boolean isActive;
	
	private Date createdAt;
	
	private Date updtedAt;
	
	private Date lastLogin;
	

}
