package com.roqet.server.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roqet.server.graphql.dto.CloudinaryImageDTO;
import com.roqet.server.graphql.dto.LocationDTO;

import lombok.Data;

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

	@Type(type="text")
	@Column(name = "cloudinary_json")
	private String cloudinaryJson;

	@Type(type="text")
	private String description;

	@Column(name = "ticket_link")
	private String ticketLink;

	@Type(type="text")
	private String agenda;

	public Event() {}

	public void setLocation(LocationDTO location) throws Exception {
		if (location == null) return;

		this.locationId = location.getId();
		this.locationName = location.getName();
		this.locationAddress = location.getAddress();
		this.locationGeometry = location.getGeometryJson();
	}

	public void setCloudinaryFromJson(CloudinaryImageDTO json) throws Exception {
		ObjectMapper ow = new ObjectMapper();
		this.cloudinaryJson = ow.writeValueAsString(json);
	}

	public CloudinaryImageDTO getCloudinaryImageDto() throws Exception {
		if (this.cloudinaryJson == null || this.cloudinaryJson.isEmpty()) return CloudinaryImageDTO.builder().build();

		ObjectMapper ow = new ObjectMapper();
		return ow.readValue(this.cloudinaryJson, CloudinaryImageDTO.class);
	}
}
