package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.Role;
import com.cpena.contactos.back.services.dtos.roles.RoleDto;

public interface IRoleService {
	
	public void createRole( RoleDto roledto );
	
	public void updateRole( Long roleId, RoleDto roleDto );
	
	public List<RoleDto> getRoles();
	
	public Role getRoleByName();
	
	public void deleteRole(Long roleId);
	

}
