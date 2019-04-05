package com.roqet.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.roqet.server.google.services.PlaceApiService;

@RestController
public class RoqetController extends BaseRestController {

	@Autowired
	private PlaceApiService placeApiService;

//	@RequestMapping(value = "/place", method = RequestMethod.GET)
//	public String getPlace(@RequestParam(value = "input") String input,
//			@RequestParam(value = "fields", required = false) String fields) {
//		return placeApiService.findPlace(input);
//	}
}
