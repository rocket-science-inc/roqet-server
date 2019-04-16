package com.roqet.server.google.parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.roqet.server.graphql.dto.GeometryDTO;
import com.roqet.server.graphql.dto.LocationDTO;

public class JsonUtils {

	public static List<LocationDTO> parseLocations(String json) {
		if (json == null || json.isEmpty()) return Collections.EMPTY_LIST;

		List<LocationDTO> result = new ArrayList<>();
		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();

		JsonArray predictions = jsonObj.getAsJsonArray("predictions");

		LocationDTO tmp;
		JsonElement element;
		JsonObject strForm;
		for (int i = 0; i < predictions.size(); i++) {
			element = predictions.get(i);
			strForm = element.getAsJsonObject().get("structured_formatting").getAsJsonObject();
			tmp = LocationDTO.builder()
					.id(element.getAsJsonObject().get("place_id").getAsString())
					.name(strForm.get("main_text").getAsString())
					.address(element.getAsJsonObject().get("description").getAsString())
					.geometry(GeometryDTO.builder().latitude("NaN").longitude("NaN").build())
					.build();
			result.add(tmp);
		}

		return result;
	}

	public static LocationDTO parseLocation(String json) {
		if (json == null || json.isEmpty()) return LocationDTO.builder().build();

		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();

		JsonObject result = jsonObj.getAsJsonObject("result");
		JsonObject geometry = result.getAsJsonObject().get("geometry").getAsJsonObject();
		JsonObject locationJson = geometry.getAsJsonObject().get("location").getAsJsonObject();

		return LocationDTO.builder()
				.id(result.getAsJsonObject().get("place_id").getAsString())
				.geometry(GeometryDTO.builder().latitude(locationJson.get("lat").getAsString())
						.longitude(locationJson.get("lng").getAsString()).build())
				.address(result.getAsJsonObject().get("vicinity").getAsString())
				.name(result.getAsJsonObject().get("name").getAsString())
				.build();
	}
}
