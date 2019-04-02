package com.roqet.server.controllers;

import com.roqet.server.google.PlaceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoqetController extends BaseRestController {

	@Autowired
	private PlaceApiService placeApiService;

	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public String getPlace(@RequestParam(value = "input") String input,
			@RequestParam(value = "fields", required = false) String fields) {
		return placeApiService.findPlace(input);
	}
}
