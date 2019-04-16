package com.roqet.server.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.roqet.server.graphql.dto.CloudinaryImageDTO;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventTime;
import com.roqet.server.graphql.dto.LocationDTO;
import com.roqet.server.graphql.dto.RecordsDTO;
import com.roqet.server.services.EventService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private EventService eventService;

	public EventDTO createEvent(String title, Integer organizer, CloudinaryImageDTO image, String description,
			String ticketLink, LocationDTO location, EventTime time,
			List<RecordsDTO>  agenda) throws Exception {

		EventDTO eventDTO = EventDTO.builder()
				.title(title)
				.organizer(organizer)
				.image(image)
				.description(description)
				.ticketLink(ticketLink)
				.location(location)
				.time(time)
				.agenda(agenda)
				.build();


		return eventService.createEvent(eventDTO);
	}
}
