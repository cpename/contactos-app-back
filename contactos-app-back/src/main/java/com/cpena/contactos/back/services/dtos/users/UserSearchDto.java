package com.cpena.contactos.back.services.dtos.users;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserSearchDto {
	
	private String userName;
	private String userLastname;
	private String userEmail;
	private String isActive;
	private String isNotActive;
	

}
