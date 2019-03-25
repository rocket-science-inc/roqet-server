package com.roqet.server.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import org.hibernate.annotations.Type;

@Data
@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;

	private Integer organizer;

	private Date start;

	private Date end;

	private String location;

	private String image;

	@Type(type="text")
	private String description;

	@Column(name = "ticket_link")
	private String ticketLink;

	@Type(type="text")
	private String agenda;

	public Event() {}
}
