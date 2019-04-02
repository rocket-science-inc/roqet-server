package com.roqet.server.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.roqet.server.graphql.dto.LocationDTO;
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

	@Column(name = "location_id")
	private String locationId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "location_address")
	private String locationAddress;

	@Column(name = "location_geometry")
	private String locationGeometry;

	private String image;

	@Type(type="text")
	private String description;

	@Column(name = "ticket_link")
	private String ticketLink;

	@Type(type="text")
	private String agenda;

	public Event() {}

	public void setLocation(LocationDTO location) {
		if (location == null) return;

		this.locationId = location.getId();
		this.locationName = location.getName();
		this.locationAddress = location.getAddress();
		this.locationGeometry = location.getGeometry();
	}

}
