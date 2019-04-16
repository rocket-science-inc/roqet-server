package com.roqet.server.graphql.resolvers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.services.EventService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private EventService eventService;

	public EventDTO createEvent(EventDTO event) throws Exception {

//		EventDTO eventDTO = EventDTO.builder()
//				.title(title)
//				.organizer(organizer)
//				.image(image)
//				.description(description)
//				.ticketLink(ticketLink)
//				.location(location)
//				.time(time)
//				.agenda(agenda)
//				.build();


		return eventService.createEvent(event);
	}
}
