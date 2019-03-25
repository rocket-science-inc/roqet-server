package com.roqet.server.graphql.dto;

import java.util.List;

import lombok.Data;

@Data
public class FeedDTO {

	private int count;

	private int page;

	private int next;

	private List<EventDTO> records;
}
