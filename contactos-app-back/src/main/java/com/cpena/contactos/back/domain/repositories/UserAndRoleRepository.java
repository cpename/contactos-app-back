package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.UserAndRole;

public interface UserAndRoleRepository extends JpaRepository<UserAndRole, Long> {

}
