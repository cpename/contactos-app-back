package com.cpena.contactos.back.services.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.users.UserCreateDto;
import com.cpena.contactos.back.services.dtos.users.UserDto;

@Mapper(componentModel = "default")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto userToUserDto(User user);	
	
	User userDtoToUser(UserDto userDto);
	
	User userCreateDtoToUser(UserCreateDto userDto);
		
	List<UserDto> userToUserDto(List<User> users);
	
//	@Mapping(target = "id", ignore = true)
//	UserDto createUserDTOWithoutId(User user);
	

}
