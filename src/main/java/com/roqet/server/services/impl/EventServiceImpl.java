package com.roqet.server.services.impl;

import static com.roqet.server.utils.ConvertDTO.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.roqet.server.db.entities.Event;
import com.roqet.server.db.entities.User;
import com.roqet.server.db.repositories.EventRepository;
import com.roqet.server.db.repositories.UserRepository;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.EventsResponseDTO;
import com.roqet.server.graphql.dto.UserDTO;
import com.roqet.server.services.EventService;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public EventDTO createEvent(EventDTO eventDTO) throws Exception {
		UserDTO organizer = eventDTO.getOrganizer();
		User user = userRepository.findById(organizer.getId()).orElse(null);

		Event event = convertIntoEvent(eventDTO, user);
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


	@Override
	@Transactional
	public EventsResponseDTO events(int count, int page) throws Exception {
		Page<Event> events = eventRepository.findAll(PageRequest.of(page, count));
		return EventsResponseDTO.builder()
				.total(events.getTotalElements())
				.pages(events.getTotalPages())
				.records(convertEvents(events.getContent())).build();
	}
}
