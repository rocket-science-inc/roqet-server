package com.roqet.server.google.services;

import java.util.List;

import com.roqet.server.graphql.dto.LocationDTO;

public interface PlaceApiService {

	List<LocationDTO> findLocations(String input);

	LocationDTO findLocation(String input);

}
