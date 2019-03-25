package com.roqet.server.graphql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventTime {

	private Long start;

	private Long end;

	public EventTime() {}
}

