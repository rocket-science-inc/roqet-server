package com.roqet.server.google.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.roqet.server.google.dto.PlacesDTO;

public class JsonUtils {

	public static List<PlacesDTO> parsePlaces(String json) {
		List<PlacesDTO> result = new ArrayList<>();
		JsonObject jsonObj = new JsonParser().parse(json).getAsJsonObject();

		JsonArray predictions = jsonObj.getAsJsonArray("predictions");

		PlacesDTO tmp;
		JsonElement element;
		JsonObject strForm;
		for (int i = 0; i < predictions.size(); i++) {
			element = predictions.get(i);
			strForm = element.getAsJsonObject().get("structured_formatting").getAsJsonObject();
			tmp = PlacesDTO.builder()
					.id(element.getAsJsonObject().get("id").getAsString())
					.name(strForm.get("main_text").getAsString())
					.secondaryText(strForm.get("secondary_text").getAsString())
					.description(element.getAsJsonObject().get("description").getAsString())
					.placeId(element.getAsJsonObject().get("place_id").getAsString())
					.build();
			result.add(tmp);
		}

		return result;
	}
}
