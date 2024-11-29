package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.Role;
import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.roles.RoleAsignDto;
import com.cpena.contactos.back.services.dtos.roles.RoleDetailDto;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;
import com.cpena.contactos.back.services.dtos.roles.UserAndRoleDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;

public interface IUserAndRoleService {
	
	public void asignRoleToUser(User user, Role role);
	public void deleteRolesToUser(Long userId, List<UserAndRoleDto> userAndRoleDtos);
	public void asignRolesToUser(Long userId, List<RoleAsignDto> roles);
	public void updateRolesToUser(Long userId, List<RoleDto> roles);
	public List<RoleDto> getRolesFromUser(Long userId);
	public List<UserDto> getUsersFromRole(Long roleId);
	
}
