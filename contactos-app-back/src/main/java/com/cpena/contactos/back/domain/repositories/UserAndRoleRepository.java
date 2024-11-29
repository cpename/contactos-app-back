package com.cpena.contactos.back.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpena.contactos.back.domain.entities.UserAndRole;
import com.cpena.contactos.back.domain.entities.UsersAndRolesKey;

public interface UserAndRoleRepository extends JpaRepository<UserAndRole, UsersAndRolesKey> {

}
