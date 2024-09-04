package com.cpena.contactos.back.domain.entities;


import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id" )
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq")
	@SequenceGenerator(name = "users_user_id_seq", sequenceName = "users_user_id_seq", allocationSize = 1 )
	private Long id;
	
	@Column(name = "user_name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "user_lastname", length = 100, nullable = false)
	private String lastname;
	
	@Column(name = "user_email", length = 100, nullable = false, unique = true )
	private String email;
	
	@Column(name = "user_password", length = 200)
	private String password;
	
	@Column(name ="user_active")
	private Boolean isActive;
	
	@Column(name = "created_at", updatable = false, nullable = false)
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
//	mapped by
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
	private Profile profile;
	
	
	
	

}
