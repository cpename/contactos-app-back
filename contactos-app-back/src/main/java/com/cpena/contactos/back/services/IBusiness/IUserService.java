package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.dtos.users.UserUpdateDto;

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
	public List<UserDto> findUsers(String searchTerm);
	
	/**
	 * Get all users registers.
	 * @return List of UserDto
	 */
	public List<UserDto> getAllUsers();
	
	/**
	 * Get user by email information.
	 * @param userEmail 
	 * @return UserDto with the user information
	 */
	public UserDto getUserByEmail(String userEmail);
	
	/**
	 * Change user password. It is necessary userId
	 * @param userId
	 * @param password
	 */
	public void changeUserPassword(Long userId, String password);
	
	/**
	 * Activate or deactivate an user
	 * @param userId
	 * @param changeActive
	 */
	public void deactivateActivateUser(Long userId, Boolean changeActive);

}
