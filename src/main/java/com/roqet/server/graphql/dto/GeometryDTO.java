package com.roqet.server.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GeometryDTO {
	private String latitude;
	private String longitude;
}
