package com.cpena.contactos.back.services.IBusiness;

import java.util.List;

import com.cpena.contactos.back.domain.entities.Profile;
import com.cpena.contactos.back.services.dtos.ProfileDto;

/**
 *  Inteface para gestionar los perfiles de los usuarios
 */
public interface IProfileService {
	
	public Profile createProfile(ProfileDto profileDto);
	public Profile updateUser(ProfileDto profileDto);
	public void deleteProfile(Long profileId);
	public List<Profile> findProfiles(String searchTerm);

}
