package com.cpena.contactos.back.domain.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "messages_message_id_seq")
	@Column(name = "message_id")
	private Integer id;
	
	@Column(name = "content_message")
	private String content;
	
	@Column(name = "sending_date")
	private Date sendingDate;
	
	@Column(name = "message_readed")
	private Boolean isReaded;
	
	@Column(name = "sender_id", unique = true)
	private Integer idSender;
	
	@Column(name = "receiverId", unique = true)
	private Integer idReceiver;
}
