package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.UserDto;

/**
 * Interface para gestionar Usuarios
 */
public interface IUserService {
	
	/**
	 * Servicio para crear un usuario. 
	 * @param userDto
	 * @return UserDto 
	 */
	public UserDto createUser(UserDto userDto);
	
	/**
	 * Servicio para actualizar un usuario. 
	 * @param userDto
	 * @return
	 */
	public User updateUser(UserDto userDto);
	
	/**
	 * Servicio para borrar un usuario. Recive el id de usuario para buscar el registro.
	 * @param userId
	 */
	public void deleteUser(Long userId);
	
	/**
	 * Servicio de buscar de usuario. Recibe una cadena de tipo String que serive de referencia para la busqueda.
	 * @param searchTerm
	 * @return
	 */
	public List<User> findUsers(String searchTerm);

}
