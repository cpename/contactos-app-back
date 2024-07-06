package com.cpena.contactos.back.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "albums")
@Data
public class Album {

	@Id
	@GeneratedValue(generator = "albums_album_id_seq", strategy = GenerationType.AUTO )
	@Column(name = "album_id")
	private Integer id;
	
	@Column(name = "album_name", unique = true, length = 50)
	private String name;
	
	@Column(name = "album_private")
	private Boolean isPrivate;
	
	@Column(name = "album_path", unique = true, length = 200)
	private String path;
	
	@Column(name = "album_creation_date")
	private Date createdAt;
	
	@Column(name = "album_update_date")
	private Date updatedAt;
	
	@Column(name = "id_profile")
	private Integer profileId;
}
