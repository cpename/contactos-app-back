package com.cpena.contactos.back.services.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.domain.repositories.UserRepository;
import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.dtos.UserDto;
import com.cpena.contactos.back.services.mapper.UserMapper;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


/**
 * Clase servicio para gestionar las funciones relacionadas con los Usuarios.
 * Crear, modificar, actualizar, borrar entre otros procesos.
 * @author capem76 * 
 */
@Service
@Slf4j
public class UserService implements IUserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	private UserMapper userMapper = UserMapper.INSTANCE;
	
		
	public UserDto getUserDTOFromUser(User user) {
		return userMapper.userToUserDto(user);
	}
	
	
	
	@PostConstruct
	public void postConstruct() {
		log.info("Creando User Service");
	}

	/**
	 * Crea un usuario segun valores en userDto.
	 * @return User entity
	 */
	public UserDto createUser(UserDto userDto) {
		User user = userMapper.userDtoToUser(userDto);
		
		return userMapper.userToUserDto( userRepository.save(user));
	}

	@Override
	public User updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findUsers(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
