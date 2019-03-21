package com.roqet.server.services;

import com.roqet.server.graphql.entities.FeedDTO;

public interface FeedService {

	FeedDTO feed(int count, int page);
}
