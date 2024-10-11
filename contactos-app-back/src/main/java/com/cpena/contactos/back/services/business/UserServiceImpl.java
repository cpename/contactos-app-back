package com.cpena.contactos.back.services.business;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cpena.contactos.back.constants.ErrorMessageEnum;
import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.domain.repositories.UserRepository;
import com.cpena.contactos.back.services.IBusiness.IUserService;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;
import com.cpena.contactos.back.services.dtos.users.UserUpdateDto;
import com.cpena.contactos.back.services.exceptions.BusinessException;
import com.cpena.contactos.back.services.mapper.UserMapper;
import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;


/**
 * Clase servicio para gestionar las funciones relacionadas con los Usuarios.
 * Crear, modificar, actualizar, borrar entre otros procesos.
 * @author capem76 * 
 */
@Service
@Slf4j
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	private UserMapper userMapper = UserMapper.INSTANCE;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
	public UserDto createUser(@NotNull UserCreateDto userDto) {
		
		checkUserExists(userDto.getName().toLowerCase(), userDto.getLastname().toLowerCase());
		checkUserEmailExist(userDto.getEmail().toLowerCase());
				
		User user = userMapper.userCreateDtoToUser(userDto);
		user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		user.setIsActive(true);
		user.setCreatedAt(new Date());
		
		return userMapper.userToUserDto( userRepository.save(user));
	}

	
	public UserDto updateUser(@NotNull Long id, @NotNull UserUpdateDto userDto) {
		
		
//		checkUserExists(userDto.getName().toLowerCase(), userDto.getLastname().toLowerCase());
//		checkUserEmailExist(userDto.getEmail().toLowerCase());
		
		User userToUpdate = userRepository.findById(Long.valueOf(id))
				.orElseThrow( () -> new BusinessException(HttpStatus.BAD_REQUEST, ErrorMessageEnum.USER_NOT_FOUND) );
		
		if(userDto.getEmail() != null)
			userToUpdate.setEmail(userDto.getEmail());
		userToUpdate.setIsActive(userDto.getIsActive());
		if( userDto.getLastname() != null)
			userToUpdate.setLastname(userDto.getLastname());
		if(userDto.getName() != null)
			userToUpdate.setName(userDto.getName());
		if(userDto.getPassword() != null)
			userToUpdate.setPassword(bCryptPasswordEncoder.encode( userDto.getPassword() ));
		userToUpdate.setUpdatedAt(new Date());
			
		
		return userMapper.userToUserDto(userRepository.save(userToUpdate));
	}

	@Override
	public void deleteUser(Long userId) {
		
		User userToDelete = userRepository.findById(userId)
				.orElseThrow( () -> new BusinessException(HttpStatus.NOT_FOUND, ErrorMessageEnum.USER_NOT_FOUND) );
		userRepository.delete(userToDelete);
		
	}

	@Override
	public List<UserDto> findUsers(String searchTerm) {
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
			throw new BusinessException(HttpStatus.NOT_FOUND, ErrorMessageEnum.RESOURCE_REQUEST_NOT_FOUND);
		
		return userMapper.userToUserDto(users);
	}
	
	
	
	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = userRepository.findAll();
		if(users.isEmpty())
			throw new BusinessException(HttpStatus.NOT_FOUND, ErrorMessageEnum.RESOURCE_REQUEST_NOT_FOUND);
		
		List<UserDto> userDtos = userMapper.userToUserDto(users);
		
		return userDtos;
	}
	
	
	
	@Override
	public UserDto getUserByEmail(String userEmail) {
//		checkUserEmailExist(userEmail);		
		List<User> userList = userRepository.findByEmailAllIgnoreCase(userEmail);
		
		if(userList.isEmpty())
			throw new BusinessException(HttpStatus.NOT_FOUND, ErrorMessageEnum.USER_NOT_FOUND);
		else if(userList.size() > 1)
			throw new BusinessException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessageEnum.USER_EMAIL_MUST_BE_UNIQUE);
		
		UserDto userDto = userMapper.userToUserDto( userList.get(0));
		
		return userDto;
	}
	
	
	
	@Override
	public void changeUserPassword(Long userId, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void deactivateActivateUser(Long userId, Boolean changeActive) {
		
		
	}
	

	
	private void checkUserExists(String name, String lastname) {
		List<User> usersList = userRepository.findByNameAndLastnameIgnoreCaseAllIgnoreCase(name, lastname);
		
		if(!usersList.isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, ErrorMessageEnum.USER_NAME_LASTNAME); 
		
		
	}
	
	private void checkUserEmailExist(String email) {
		List<User> usersList = userRepository.findByEmailAllIgnoreCase(email);
		if(!usersList.isEmpty())
			throw new BusinessException(HttpStatus.BAD_REQUEST, ErrorMessageEnum.USER_EMAIL_ALREADY_EXIST);
		
			
	}

	
	
}
