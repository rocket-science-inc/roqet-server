package com.roqet.server.graphql.dto;

import lombok.Builder;

@Builder
public class EventDTO {

	private Integer id;

	private String title;

	private EventTime time;

	private LocationDTO location;

	private String image;
}