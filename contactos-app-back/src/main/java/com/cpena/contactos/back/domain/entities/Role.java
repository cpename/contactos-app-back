package com.cpena.contactos.back.domain.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Data
public class Role {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "roles_id_seq")
	@SequenceGenerator(name = "roles_id_seq", allocationSize = 1, initialValue = 1, sequenceName = "roles_id_seq")
	private Long id;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
//	@ManyToMany(mappedBy = "roles")
//	private Set<User> users;
	
//	@JoinTable(
//			name = "users_roles",
//			joinColumns = @JoinColumn(referencedColumnName = "users_id", nullable = false),
//			inverseJoinColumns = @JoinColumn(referencedColumnName = "roles_id", nullable = false)
//	)
//	@ManyToOne(cascade = CascadeType.ALL)
//	private List<User> users;

	@OneToMany(mappedBy = "role")
	private Set<UserAndRole> usersAndRoles;
}
