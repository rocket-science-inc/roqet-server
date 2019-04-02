package com.roqet.server.google.impl;

import javax.annotation.PostConstruct;

import com.roqet.server.google.PlaceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
//@ConfigurationProperties(prefix = "google.place.api")
public class PlaceApiServiceImpl implements PlaceApiService {

	@Value("${google.place.api.key}")
	private String key;
	@Value("${google.place.api.rest}")
	private String rest;

	private static final String API_REST_TEMPLATE = "%s?input=%s&inputtype=textquery&fields=%s&key=%s";
	private static final String API_FIELDS_DEFAULT = "id,name,formatted_address,geometry";

	private String apiTemplate;

	@Autowired
	private RestTemplate restTemplate;

	@PostConstruct
	public void initRestCall() {
		this.apiTemplate = String.format(API_REST_TEMPLATE, rest, "%s", "%s", key);
	}

	public String findPlace(String input) {
		final String api = String.format(this.apiTemplate, input, API_FIELDS_DEFAULT);
		return restTemplate.getForObject(api, String.class);
	}

}