package com.roqet.server.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.roqet.server.db.entities.Event;
import com.roqet.server.db.entities.User;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventMutationDTO;
import com.roqet.server.graphql.dto.EventTime;
import com.roqet.server.graphql.dto.LocationDTO;
import com.roqet.server.graphql.dto.UserDTO;

public class ConvertDTO {

	public static EventDTO convertIntoEventDto(Event event) throws Exception {
		LocationDTO locationDTO = LocationDTO.builder()
				.id(event.getLocationId())
				.name(event.getLocationName())
				.address(event.getLocationAddress())
				.build();
		locationDTO.setGeometryJson(event.getLocationGeometry());
		EventDTO eventDTO = EventDTO.builder()
				.id(event.getId())
				.title(event.getTitle())
				.location(locationDTO)
				.image(event.getCloudinaryImageDto())
				.time(new EventTime(event))
				.organizer(convertIntoUserDto(event.getOrganizer()))
				.description(event.getDescription())
				.ticketLink(event.getTicketLink())
				.build();

		eventDTO.setJsonAgenda(event.getAgenda());
		return eventDTO;

		
	}

	public static UserDTO convertIntoUserDto(User user) {
		return UserDTO.builder()
				.id(user.getId())
				.fullName(String.format("%s %s", user.getFirstName(), user.getLastName()))
				.build();
	}

	public static List<EventDTO> convertEvents(List<Event> events) throws Exception {
		return events.stream().map(ConvertDTO::handleConvertEventDTO).collect(Collectors.toList());
	}

	public static List<UserDTO> convertUsers(List<User> users) throws Exception {
		return users.stream().map(ConvertDTO::convertIntoUserDto).collect(Collectors.toList());
	}

	private static EventDTO handleConvertEventDTO(Event event) {
		try {
			return ConvertDTO.convertIntoEventDto(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EventDTO.builder().build();
	}

	public static Event convertIntoEvent(EventDTO eventDTO, User loadedOrganizer) throws Exception {
		return convertIntoEvent(new Event(), eventDTO, loadedOrganizer);
	}

	public static Event convertIntoEvent(Event event, EventDTO eventDTO, User loadedOrganizer) throws Exception {
		if (eventDTO.getId() != null) event.setId(eventDTO.getId());
		if (eventDTO.getTitle() != null) event.setTitle(eventDTO.getTitle());
		if (loadedOrganizer != null) event.setOrganizer(loadedOrganizer);
		if (eventDTO.getLocation() != null) event.setLocation(eventDTO.getLocation());
		if (eventDTO.getImage() != null) event.setCloudinaryFromJson(eventDTO.getImage());
		if (eventDTO.getTime() != null && eventDTO.getTime().getStart() != null)
			event.setStart(new Date(eventDTO.getTime().getStart()));
		if (eventDTO.getTime() != null && eventDTO.getTime().getEnd() != null)
			event.setEnd(new Date(eventDTO.getTime().getEnd()));
		if (eventDTO.getDescription() != null) event.setDescription(eventDTO.getDescription());
		if (eventDTO.getTicketLink() != null) event.setTicketLink(eventDTO.getTicketLink());
		if (eventDTO.getJsonAgenda() != null) event.setAgenda(eventDTO.getJsonAgenda());
		 return event;
	}

	public static EventDTO convertMutationToEventDto(EventMutationDTO eventMutationDTO, UserDTO userDTO) {
		return EventDTO.builder()
				.id(eventMutationDTO.getId())
				.title(eventMutationDTO.getTitle())
				.organizer(userDTO)
				.description(eventMutationDTO.getDescription())
				.ticketLink(eventMutationDTO.getTicketLink())
				.location(eventMutationDTO.getLocation())
				.image(eventMutationDTO.getImage())
				.time(eventMutationDTO.getTime())
				.agenda(eventMutationDTO.getAgenda())
				.build();
	}
}
