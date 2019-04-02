package com.roqet.server.services;

import com.roqet.server.graphql.dto.FeedDTO;

public interface FeedService {

	FeedDTO feed(int count, int page) throws Exception;
}
