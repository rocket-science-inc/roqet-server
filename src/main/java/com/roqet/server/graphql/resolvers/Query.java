package com.roqet.server.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.roqet.server.graphql.entities.FeedDTO;
import com.roqet.server.services.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

	@Autowired
	private FeedService feedService;

	public FeedDTO feed(int count, int page) {
		return feedService.feed(count, page);
	}
}
