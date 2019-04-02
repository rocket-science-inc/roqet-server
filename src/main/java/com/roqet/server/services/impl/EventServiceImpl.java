package com.roqet.server.services.impl;

import static com.roqet.server.utils.ConvertDTO.convertIntoEvent;
import static com.roqet.server.utils.ConvertDTO.convertIntoEventDto;

import java.util.Optional;

import com.roqet.server.db.entities.Event;
import com.roqet.server.db.repositories.EventRepository;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	@Transactional
	public EventDTO createEvent(EventDTO eventDTO) throws Exception {

		Event event = convertIntoEvent(eventDTO);
		event = eventRepository.save(event);

		eventDTO.setId(event.getId());

		return eventDTO;
	}

	@Override
	@Transactional
	public EventDTO find(Integer id) throws Exception {
		Optional<Event> event = eventRepository.findById(id);
		return convertIntoEventDto(event.orElse(null));
	}
}
