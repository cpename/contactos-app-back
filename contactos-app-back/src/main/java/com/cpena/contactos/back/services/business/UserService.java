package com.cpena.contactos.back.services.business;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cpena.contactos.back.constants.ErrorMessageEnum;
import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.domain.repositories.UserRepository;
import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.dtos.UserCreateDto;
import com.cpena.contactos.back.services.dtos.UserDto;
import com.cpena.contactos.back.services.exceptions.BusinessException;
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
	 * Crea un usuario segun valores en userDto. El email es un valor unico, al igual que el nombre y el apellido.
	 * @return UserDto 
	 */	
	public UserDto createUser(UserCreateDto userDto) {
		
		checkUserExists(userDto.getName().toLowerCase(), userDto.getLastname().toLowerCase());
		checkUserEmailExist(userDto.getEmail().toLowerCase());
				
		User user = userMapper.userCreateDtoToUser(userDto);
		user.setIsActive(true);
		user.setCreatedAt(new Date());
		
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
	
	private void checkUserExists(String name, String lastname) {
		List<User> usersList = userRepository.findByNameAndLastname(name, lastname);
		
		if(!usersList.isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, ErrorMessageEnum.USER_NAME_LASTNAME); 
		
		
	}
	
	private void checkUserEmailExist(String email) {
		List<User> usersList = userRepository.findByEmail(email);
		if(!usersList.isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, ErrorMessageEnum.USER_EMAIL_ALREADY_EXIST);
			
	}
	
	
	
}
