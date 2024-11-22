package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
