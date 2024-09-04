package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.UserCreateDto;
import com.cpena.contactos.back.services.dtos.UserDto;
import com.cpena.contactos.back.services.dtos.UserUpdateDto;

/**
 * Interface para gestionar Usuarios
 */
public interface IUserService {
	
	/**
	 * Servicio para crear un usuario. 
	 * @param UserCreateDto
	 * @return UserDto 
	 */
	public UserDto createUser(UserCreateDto userDto);
	
	/**
	 * Servicio para actualizar un usuario. 
	 * @param userDto
	 * @return
	 */
	public UserDto updateUser(Long userId, UserUpdateDto userDto);
	
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
