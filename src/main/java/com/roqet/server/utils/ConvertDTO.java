package com.roqet.server.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.roqet.server.db.entities.Event;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventDetailsDTO;
import com.roqet.server.graphql.dto.EventTime;
import com.roqet.server.graphql.dto.LocationDTO;

public class ConvertDTO {

	public static EventDTO convertIntoEventDto(Event event) {
		return EventDTO.builder()
				.title(event.getTitle())
				.location(new LocationDTO(event.getLocation()))
				.image(event.getImage())
				.time(new EventTime())
				.build();
	}

	public static List<EventDTO> convertEvents(List<Event> events) {
		return events.stream().map(ConvertDTO::convertIntoEventDto).collect(Collectors.toList());
	}

	public static Event convertIntoEvent(EventDetailsDTO eventDetails) throws Exception {
		Event event = new Event();
		event.setTitle(eventDetails.getTitle());
		event.setOrganizer(eventDetails.getOrganizer());
		event.setLocation(eventDetails.getLocation().getStreetAddress());
		event.setImage(eventDetails.getImage());
		event.setStart(new Date(eventDetails.getTime().getStart()));
		event.setEnd(new Date(eventDetails.getTime().getEnd()));
		event.setDescription(eventDetails.getDescription());
		event.setTicketLink(eventDetails.getTicketLink());
		event.setAgenda(eventDetails.getJsonAgenda());
		 return event;
	}

	public static EventDetailsDTO convertIntoEventDetails(Event event) throws Exception {
		if (event == null) return null;

		EventDetailsDTO eventDetails = EventDetailsDTO.builder()
				.id(event.getId())
				.title(event.getTitle())
				.organizer(event.getOrganizer())
				.location(new LocationDTO(event.getLocation()))
				.image(event.getImage())
				.time(new EventTime(event.getStart().getTime(), event.getEnd().getTime()))
				.description(event.getDescription())
				.build();

		eventDetails.setJsonAgenda(event.getAgenda());

		return eventDetails;
	}

}
