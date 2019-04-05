package com.roqet.server.google.services;

import java.util.List;

import com.roqet.server.google.dto.PlacesDTO;

public interface PlaceApiService {

	List<PlacesDTO> findPlace(String input);

}
