package com.cpena.contactos.back.services.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cpena.contactos.back.domain.entities.Role;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;

@Mapper(componentModel = "default")
public interface RoleMapper {

	RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	RoleDto roleToRoleDto(Role role);
	
	Role roleDtoToRole(RoleDto roleDto);
	
	List<RoleDto> rolesToRoleDtos(List<Role> role);
	
}
