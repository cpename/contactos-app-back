package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
	
	List<User> findByNameAndLastnameIgnoreCaseAllIgnoreCase(String name, String lastname);
	
	List<User> findByEmailAllIgnoreCase(String email);
	
	

}
