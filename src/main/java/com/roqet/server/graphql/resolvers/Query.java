package com.roqet.server.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.roqet.server.graphql.dto.EventDetailsDTO;
import com.roqet.server.graphql.dto.FeedDTO;
import com.roqet.server.services.EventService;
import com.roqet.server.services.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
	private FeedService feedService;

	@Autowired
	private EventService eventService;


	public FeedDTO feed(int count, int page) {
		return feedService.feed(count, page);
	}

	public EventDetailsDTO event(int id) throws Exception {
		return eventService.find(id);
	}
}
