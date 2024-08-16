package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.Profile;

public interface ProfileRespository extends JpaRepository<Profile, Long>{

}
