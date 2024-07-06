package com.cpena.contactos.back.entities;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	
//	private static final Logger log = LoggerFactory.getLogger(User.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "users_user_id_seq")
	@Column(name = "user_id" )
	private Integer id;
	
	@Column(name = "user_name", length = 100, nullable = false)
	private String name;
	
	@Column(name = "user_lastname", length = 100, nullable = false)
	private String lastname;
	
	@Column(name = "user_email", length = 100, nullable = false, unique = true )
	private String email;
	
	@Column(name = "user_password", length = 200)
	private String password;
	
	@Column(name ="user_active")
	private boolean isActive;
	
	@Column(name = "created_at")
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
