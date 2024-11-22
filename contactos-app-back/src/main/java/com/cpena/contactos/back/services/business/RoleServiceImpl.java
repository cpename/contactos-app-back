package com.cpena.contactos.back.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.cpena.contactos.back.domain.entities.Role;
import com.cpena.contactos.back.domain.repositories.RoleRepository;
import com.cpena.contactos.back.services.IBusiness.IRoleService;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;
import com.cpena.contactos.back.services.exceptions.BusinessException;
import com.cpena.contactos.back.services.mapper.RoleMapper;



@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	private RoleMapper roleMapper= RoleMapper.INSTANCE;
	
	

	@Override
	public void createRole(RoleDto roledto) {
		Role role = roleMapper.roleDtoToRole(roledto);
		roleRepository.save(role);
		
		
	}

	@Override
	public void updateRole(Long roleId, RoleDto roleDto) {
		Role role = roleRepository.findById(roleId)
			.orElseThrow( () -> new BusinessException(HttpStatus.NOT_FOUND, "Role not found") );		
		role.setName(roleDto.getName());
		
		roleRepository.save(role);		
	}

	@Override
	public List<RoleDto> getRoles() {
		List<Role> roles = roleRepository.findAll();
		List<RoleDto> roleDtos = roleMapper.rolesToRoleDtos(roles);
		
		return roleDtos;
	}

	@Override
	public Role getRoleByName() {
		
		return null;
	}

	@Override
	public void deleteRole(Long roleId) {
		Role role = roleRepository.findById(roleId)
				.orElseThrow( () -> new BusinessException(HttpStatus.NOT_FOUND, "Role not found") );
		roleRepository.delete(role);
		
	}
	
}
