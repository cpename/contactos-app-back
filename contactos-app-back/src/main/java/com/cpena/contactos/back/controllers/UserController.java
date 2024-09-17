package com.cpena.contactos.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpena.contactos.back.constants.Constants;
import com.cpena.contactos.back.services.business.UserServiceImpl;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.dtos.users.UserUpdateDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(Constants.BASE_URI + "/users")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
		
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> createUser( @RequestBody @Valid @NotNull UserCreateDto nuevoUserDto ){
		
		UserDto userDto = userServiceImpl.createUser(nuevoUserDto);
		
		return ResponseEntity.ok( userDto );			
		
	}
	
	@PutMapping(value = "/{userId}/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> updateUser( @NotNull @PathVariable Long userId, @Valid @NotNull @RequestBody UserUpdateDto userUpdateDto ){
		
		UserDto userDto = userServiceImpl.updateUser(userId, userUpdateDto);
		
		return ResponseEntity.ok(userDto);
	}
	
}
