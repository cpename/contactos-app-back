package com.cpena.contactos.back.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.cpena.contactos.back.domain.entities.User;
import com.cpena.contactos.back.services.dtos.UserDto;

@Mapper(componentModel = "default")
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	UserDto userToUserDto(User user);
	
	User userDtoToUser(UserDto userDto);
	
	@Mapping(target = "id", ignore = true)
	UserDto createUserDTOWithoutId(User user);
	

}
