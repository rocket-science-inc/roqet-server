package com.roqet.server.google.services.impl;

import static com.roqet.server.google.parser.JsonUtils.parseLocation;
import static com.roqet.server.google.parser.JsonUtils.parseLocations;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.roqet.server.google.services.PlaceApiService;
import com.roqet.server.graphql.dto.LocationDTO;



@Component
//@ConfigurationProperties(prefix = "google.place.api")
public class PlaceApiServiceImpl implements PlaceApiService {

	@Value("${google.place.api.key}")
	private String key;
	@Value("${google.place.api.rest}")
	private String rest;

	private static final String API_REST_AUTOCOMPLETE = "%s/autocomplete/json?input=%s&key=%s&sessiontoken=%s";
	private static final String API_REST_DETAILS = "%s/details/json?placeid=%s&fields=place_id,name,geometry,vicinity&key=%s&sessiontoken=%s";


	private String apiTemplateAuto;
	private String apiTemplateDetails;

	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void initRestCall() {
		this.apiTemplateAuto = String.format(API_REST_AUTOCOMPLETE, rest, "%s", key, UUID.randomUUID());
		this.apiTemplateDetails = String.format(API_REST_DETAILS, rest, "%s", key, UUID.randomUUID());
	}

	public List<LocationDTO> findLocations(String input) {
		final String api = String.format(this.apiTemplateAuto, input);
		String json = restTemplate.getForObject(api, String.class);
		return parseLocations(json);
	}

	public LocationDTO findLocation(String input) {
		final String api = String.format(this.apiTemplateDetails, input);
		String json = restTemplate.getForObject(api, String.class);
		return parseLocation(json);
	}

}