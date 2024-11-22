package com.cpena.contactos.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpena.contactos.back.constants.Constantes;
import com.cpena.contactos.back.services.IBusiness.IRoleService;
import com.cpena.contactos.back.services.business.RoleServiceImpl;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;


import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = Constantes.BASE_URI + "/roles")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> createRole(@RequestBody @NotNull RoleDto roleDto ){
		
		roleService.createRole(roleDto);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	
}
