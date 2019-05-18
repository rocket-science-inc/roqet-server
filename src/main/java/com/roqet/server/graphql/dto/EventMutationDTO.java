package com.roqet.server.graphql.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class EventMutationDTO {

	private Integer id;

	private String title;

	private Integer organizer;

	private String description;

	private String ticketLink;

	private LocationDTO location;

	private CloudinaryImageDTO image;

	private EventTime time;

	private List<RecordsDTO> agenda;
}