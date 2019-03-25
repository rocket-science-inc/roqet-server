package com.roqet.server.services;

import com.roqet.server.graphql.dto.EventDetailsDTO;

public interface EventService {

	EventDetailsDTO createEvent(EventDetailsDTO eventDetailsDTO) throws Exception;

	EventDetailsDTO find(Integer id) throws Exception;

}
