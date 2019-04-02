package com.roqet.server.graphql.dto;

import com.roqet.server.db.entities.Event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventTime {

	private Long start;

	private Long end;

	public EventTime(Event event) {
		if (event == null) return;

		this.start = event.getStart().getTime();
		this.end = event.getEnd().getTime();
	}
}

