package com.roqet.server.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.roqet.server.db.entities.Event;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventTime;
import com.roqet.server.graphql.dto.LocationDTO;

public class ConvertDTO {

	public static EventDTO convertIntoEventDto(Event event) throws Exception {
		EventDTO eventDTO = EventDTO.builder()
				.id(event.getId())
				.title(event.getTitle())
				.location(new LocationDTO(event.getLocationId(), event.getLocationName(),
						event.getLocationAddress(), event.getLocationGeometry()))
				.image(event.getImage())
				.time(new EventTime(event))
				.organizer(event.getOrganizer())
				.description(event.getDescription())
				.ticketLink(event.getTicketLink())
				.build();

		eventDTO.setJsonAgenda(event.getAgenda());
		return eventDTO;

		
	}

	public static List<EventDTO> convertEvents(List<Event> events) throws Exception {
		return events.stream().map(ConvertDTO::handleConvertEventDTO).collect(Collectors.toList());
	}

	private static EventDTO handleConvertEventDTO(Event event) {
		try {
			return ConvertDTO.convertIntoEventDto(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EventDTO.builder().build();
	}

	public static Event convertIntoEvent(EventDTO eventDTO) throws Exception {
		Event event = new Event();
		event.setTitle(eventDTO.getTitle());
		event.setOrganizer(eventDTO.getOrganizer());
		event.setLocation(eventDTO.getLocation());
		event.setImage(eventDTO.getImage());
		event.setStart(new Date(eventDTO.getTime().getStart()));
		event.setEnd(new Date(eventDTO.getTime().getEnd()));
		event.setDescription(eventDTO.getDescription());
		event.setTicketLink(eventDTO.getTicketLink());
		event.setAgenda(eventDTO.getJsonAgenda());
		 return event;
	}
}
