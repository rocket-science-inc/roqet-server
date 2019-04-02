package com.roqet.server.graphql.resolvers;

import java.util.List;

import com.roqet.server.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.roqet.server.graphql.dto.AgendaPartDTO;
import com.roqet.server.graphql.dto.EventDetailsDTO;
import com.roqet.server.graphql.dto.EventTime;
import com.roqet.server.graphql.dto.LocationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private EventService eventService;

	public EventDetailsDTO createEvent(String title, Integer organizer, String image, String description,
			String ticketLink, LocationDTO location, EventTime time,
			List<AgendaPartDTO>  agenda) throws Exception {

		EventDetailsDTO eventDetails = EventDetailsDTO.builder()
				.title(title)
				.organizer(organizer)
				.image(image)
				.description(description)
				.ticketLink(ticketLink)
				.location(location)
				.time(time)
				.agenda(agenda)
				.build();


		return eventService.createEvent(eventDetails);
	}
}
