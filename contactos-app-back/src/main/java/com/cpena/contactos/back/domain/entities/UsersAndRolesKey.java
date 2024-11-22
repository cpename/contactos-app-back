package com.cpena.contactos.back.domain.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
//@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UsersAndRolesKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	Long userId;
	
	@Column(name = "role_id")
	Long roleId;
	

}
