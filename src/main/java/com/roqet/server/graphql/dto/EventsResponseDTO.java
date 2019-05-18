package com.roqet.server.graphql.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EventsResponseDTO {

	private Long total;

	private Integer pages;

	private List<EventDTO> records;
}
