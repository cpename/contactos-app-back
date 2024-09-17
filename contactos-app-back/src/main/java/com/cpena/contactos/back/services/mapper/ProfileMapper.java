package com.cpena.contactos.back.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.cpena.contactos.back.domain.entities.Profile;
import com.cpena.contactos.back.services.dtos.profiles.ProfileDto;

@Mapper(componentModel = "default")
public interface ProfileMapper {
	
	ProfileMapper INSTANCE = Mappers.getMapper(ProfileMapper.class);
	
	ProfileDto profileToProfileDto(Profile profile);
	
	Profile profileDtoToProfile(ProfileDto profileDto);

}
