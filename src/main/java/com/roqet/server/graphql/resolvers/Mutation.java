package com.roqet.server.graphql.resolvers;

import static com.roqet.server.utils.ConvertDTO.convertMutationToEventDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventMutationDTO;
import com.roqet.server.graphql.dto.UserDTO;
import com.roqet.server.services.EventService;
import com.roqet.server.services.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	private EventService eventService;
	@Autowired
	private UserService userService;

	public EventDTO createEvent(EventMutationDTO event) throws Exception {
		return createOrUpdateEvent(event);
	}

	public EventDTO updateEvent(EventMutationDTO event) throws Exception {
		return createOrUpdateEvent(event);
	}

	private EventDTO createOrUpdateEvent(EventMutationDTO event) throws Exception {
		Integer organizerId = event.getOrganizer();
		UserDTO user = userService.user(organizerId);

		return eventService.createOrUpdateEvent(convertMutationToEventDto(event, user));
	}
}
