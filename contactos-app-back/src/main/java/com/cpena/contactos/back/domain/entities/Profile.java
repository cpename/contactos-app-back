package com.cpena.contactos.back.domain.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "profiles_id_profile_seq")
	@Column(name = "id_profile")
	private Long id;
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
	private List<User> users; 

}
