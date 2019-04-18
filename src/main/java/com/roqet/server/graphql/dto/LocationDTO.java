package com.roqet.server.graphql.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LocationDTO {

	private String id;

	private String name;

	private String address;

	private GeometryDTO geometry;

	public void setGeometryJson(String json) throws Exception {
		if (json == null || json.isEmpty()) {
			this.geometry = new GeometryDTO("NaN", "NaN");
			return;
		}

		ObjectMapper ow = new ObjectMapper();
		this.geometry =  ow.readValue(json, GeometryDTO.class);
	}

	public String getGeometryJson() throws Exception {
		ObjectMapper ow = new ObjectMapper();
		return ow.writeValueAsString(this.geometry);
	}
}