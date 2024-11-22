package com.cpena.contactos.back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cpena.contactos.back.constants.Constantes;
import com.cpena.contactos.back.services.IBusiness.IRoleService;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@RequestMapping(value = Constantes.BASE_URI + "/roles")
public class UserAndRolesController {
	
	@Autowired
	private IRoleService roleService;
	
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoleDto>> getAllRoles(){		
		List<RoleDto> roles = roleService.getRoles();		
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{roleId}")
	public ResponseEntity<HttpStatus> updateRole(@PathVariable @NotNull  Long roleId, @RequestBody @NotNull RoleDto roleDto){
		
		roleService.updateRole(roleId, roleDto);
		
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(204));
	}
	
	@PostMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> saveRole(RoleDto roleDto){
		
		roleService.createRole(roleDto);
		
		return new ResponseEntity<>(HttpStatusCode.valueOf(201));
	}
	
	

}
