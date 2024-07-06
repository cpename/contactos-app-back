package com.cpena.contactos.back.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "profiles")
@Data
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "profiles_id_profile_seq")
	@Column(name = "id_profile")
	private Integer id;
	
	@Column(name = "name_profile", nullable = false, unique = true, length = 100)
	private String name;
	
	@Column(name = "birthday_profile")
	private Date birthday;
	
	@Column(name = "gender_profile", length = 50)
	private String gender;
	
	@Column(name = "role", length = 50)
	private String role;
	
	@Column(name = "biography")
	private String biography;
	
	@Column(name = "photo_profile")
	private String photo;
	
	@Column(name = "location_profile")
	private String location;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@OneToMany(mappedBy = "profile")
	private List<User> users; 

}
