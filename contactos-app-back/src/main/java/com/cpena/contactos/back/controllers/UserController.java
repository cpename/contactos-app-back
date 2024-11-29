package com.cpena.contactos.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpena.contactos.back.constants.Constantes;
import com.cpena.contactos.back.services.IBusiness.IUserAndRoleService;
import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.dtos.roles.RoleAsignDto;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;
import com.cpena.contactos.back.services.dtos.roles.UserAndRoleDto;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.dtos.users.UserUpdateDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(Constantes.BASE_URI + "/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IUserAndRoleService userAndRoleService;
	
//	@Autowired
//	private IUserAndRoleService userAndRoleService;
		
	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> createUser( @RequestBody @Valid @NotNull UserCreateDto nuevoUserDto ){
		
		UserDto userDto = userService.createUser(nuevoUserDto);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);		
		
	}
	
	@PutMapping(value = "/{userId}/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> updateUser( @NotNull @PathVariable Long userId, @Valid @NotNull @RequestBody UserUpdateDto userUpdateDto ){
		
		UserDto userDto = userService.updateUser(userId, userUpdateDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value ="/delete/{userId}/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable @NotNull Long userId){
		
		userService.deleteUser(userId);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<UserDto> userDtos = userService.getAllUsers();
		
		return new ResponseEntity<>(userDtos, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/{userId}/roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> asignRolesToUser( @PathVariable @NotNull Long userId, @NotNull @RequestBody List<RoleAsignDto> roleAsignDtos  ){
		
		userService.asignRolesToUser(userId, roleAsignDtos);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{userId}/roles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> deleteRolesToUser(@PathVariable @NotNull Long userId, @NotNull @RequestBody List<UserAndRoleDto> userAndRoleDtos){
		
		userAndRoleService.deleteRolesToUser(userId, userAndRoleDtos);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
		
	
	
}

