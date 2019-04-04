package com.roqet.server.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {

	private String id;

	private String name;

	private String address;

	private String geometry;

//	public LocationDTO(Event event) {
//		if (event == null) return;
//
//		this.id = event.getLocationId();
//		this.name = event.getLocationName();
//		this.address = event.getLocationAddress();
//		this.geometry = event.getLocationGeometry();
//	}

}
