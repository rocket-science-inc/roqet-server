package com.roqet.server.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.roqet.server.db.entities.Event;
import com.roqet.server.graphql.entities.EventDTO;
import com.roqet.server.graphql.entities.LocationDTO;

public class ConvertDTO {

	public static EventDTO convertEvent(Event event) {
		return EventDTO.builder()
				.id(event.getId())
				.title(event.getTitle())
				.location(new LocationDTO(event.getLocation()))
				.image(event.getImage())
				.start(event.getStart())
				.build();
	}

	public static List<EventDTO> convertEvents(List<Event> events) {
		return events.stream().map(ConvertDTO::convertEvent).collect(Collectors.toList());
	}

}
