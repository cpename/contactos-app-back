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
@Table(name = "photos")
@Data
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "photos_photo_id_seq")
	@Column(name = "photo_id")
	private Integer id;
	
	@Column(name = "photo_name", length = 50, unique = true)
	private String name;
	
	@Column(name = "photo_url", length = 100, unique = true)
	private String url;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "album_id")
	private Integer albumId;
}
