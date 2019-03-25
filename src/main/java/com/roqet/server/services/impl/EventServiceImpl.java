package com.roqet.server.services.impl;

import static com.roqet.server.utils.ConvertDTO.convertIntoEvent;
import static com.roqet.server.utils.ConvertDTO.convertIntoEventDetails;

import java.util.Optional;

import com.roqet.server.db.entities.Event;
import com.roqet.server.db.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roqet.server.graphql.dto.EventDetailsDTO;
import com.roqet.server.services.EventService;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	@Transactional
	public EventDetailsDTO createEvent(EventDetailsDTO eventDetailsDTO) throws Exception {

		Event event = convertIntoEvent(eventDetailsDTO);
		event = eventRepository.save(event);

		eventDetailsDTO.setId(event.getId());

		return eventDetailsDTO;
	}

	@Override
	@Transactional
	public EventDetailsDTO find(Integer id) throws Exception {
		Optional<Event> event = eventRepository.findById(id);
		return convertIntoEventDetails(event.orElse(null));
	}
}
