package com.roqet.server.graphql.entities;

import java.util.List;

import lombok.Data;

@Data
public class FeedDTO {

	private int count;

	private int page;

	private int next;

	private List<EventDTO> records;
}
