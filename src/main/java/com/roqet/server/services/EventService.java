package com.roqet.server.services;

import com.roqet.server.graphql.dto.EventDTO;

public interface EventService {

	EventDTO createEvent(EventDTO eventDTO) throws Exception;

	EventDTO find(Integer id) throws Exception;

}
