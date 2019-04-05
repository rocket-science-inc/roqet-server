package com.roqet.server.google.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacesDTO {

	private String id;

	private String name;

	private String secondaryText;

	private String description;

	private String placeId;
}
