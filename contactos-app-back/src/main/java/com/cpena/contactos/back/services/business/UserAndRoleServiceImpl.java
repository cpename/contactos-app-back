package com.cpena.contactos.back.services.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.cpena.contactos.back.domain.entities.Role;
import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.domain.entities.UserAndRole;
import com.cpena.contactos.back.domain.entities.UsersAndRolesKey;
import com.cpena.contactos.back.domain.repositories.RoleRepository;
import com.cpena.contactos.back.domain.repositories.UserAndRoleRepository;
import com.cpena.contactos.back.domain.repositories.UserRepository;
import com.cpena.contactos.back.services.IBusiness.IUserAndRoleService;
import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.dtos.roles.RoleAsignDto;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.exceptions.BusinessException;

@Service
public class UserAndRoleServiceImpl implements IUserAndRoleService {
	
	@Autowired
	private UserAndRoleRepository userAndRoleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	


	@Override
	public void deleteRoleToUser(Long userId, Long roleID) {
		User user = userRepository.findById(userId).
				orElseThrow( () -> new BusinessException(HttpStatus.NOT_FOUND, "User Not found") );
		
		
		
	}


	@Override
	public void asignRolesToUser(Long userId, List<RoleAsignDto> asignRolesDto) {

	}

	@Override
	public void updateRolesToUser(Long userId, List<RoleDto> roles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RoleDto> getRolesFromUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getUsersFromRole(Long roleId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void asignRoleToUser(User user, Role role) {
		
		
		
	}


}
