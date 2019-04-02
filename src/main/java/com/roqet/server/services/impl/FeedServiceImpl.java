package com.roqet.server.services.impl;

import static com.roqet.server.utils.ConvertDTO.convertEvents;

import java.util.List;

import com.roqet.server.db.entities.Event;
import com.roqet.server.db.repositories.EventRepository;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.FeedDTO;
import com.roqet.server.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class FeedServiceImpl implements FeedService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public FeedDTO feed(int count, int page) throws Exception {
		FeedDTO feedDTO = new FeedDTO();
		feedDTO.setCount(count);
		feedDTO.setPage(page);
		feedDTO.setNext(count);
		feedDTO.setRecords(getEvents(count, page));
		return feedDTO;
	}

	private List<EventDTO> getEvents(int count, int page) throws Exception {
		Page<Event> events = eventRepository.findAll(PageRequest.of(page, count));

		return convertEvents(events.getContent());
	}
}
