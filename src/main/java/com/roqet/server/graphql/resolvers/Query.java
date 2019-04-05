package com.roqet.server.graphql.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.roqet.server.google.dto.PlacesDTO;
import com.roqet.server.google.services.PlaceApiService;
import com.roqet.server.graphql.dto.EventDTO;
import com.roqet.server.graphql.dto.FeedDTO;
import com.roqet.server.services.EventService;
import com.roqet.server.services.FeedService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
	private FeedService feedService;

	@Autowired
	private EventService eventService;

	@Autowired
	private PlaceApiService placeApiService;


	public FeedDTO feed(int count, int page) throws Exception {
		return feedService.feed(count, page);
	}

	public EventDTO event(int id) throws Exception {
		return eventService.find(id);
	}

	public List<EventDTO> events(int count, int page) throws Exception {
		return eventService.events(count, page);
	}

	public List<PlacesDTO> findPlace(String input) {
		return placeApiService.findPlace(input);
	}
}
