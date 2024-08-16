package com.cpena.contactos.back.services.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProfileDto {
	
	@NotNull
	private String name;
	
	@NotNull	
	private Date birthDay;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String role;
	
	@Size(max = 500, message = "Maximu characters is 500")
	private String biography;
	
	@Size(max = 200, message = "long is 200 characters")
	private String photo;
	
	private String location;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	@NotEmpty(message = "A profile must be related to an User, it can not be null or empty")
	private Long userId;


	
	
	

}
