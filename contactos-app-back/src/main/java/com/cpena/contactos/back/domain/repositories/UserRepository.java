package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
