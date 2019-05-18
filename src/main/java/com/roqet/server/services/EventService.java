package com.roqet.server.services;

import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventsResponseDTO;

public interface EventService {

	EventDTO createEvent(EventDTO eventDTO) throws Exception;

	EventDTO find(Integer id) throws Exception;

	EventsResponseDTO events(int count, int page) throws Exception;

}
