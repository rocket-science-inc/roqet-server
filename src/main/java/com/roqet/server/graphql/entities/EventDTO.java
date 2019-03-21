package com.roqet.server.graphql.entities;

import java.util.Date;

import lombok.Builder;

@Builder
public class EventDTO {

	private Integer id;

	private String title;

	private Date start;

	private LocationDTO location;

	private String image;
}
