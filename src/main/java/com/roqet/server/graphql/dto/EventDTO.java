package com.roqet.server.graphql.dto;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EventDTO {

	private Integer id;

	private String title;

	private Integer organizer;

	private String description;

	private String ticketLink;

	private LocationDTO location;

	private CloudinaryImageDTO image;

	private EventTime time;

	private List<RecordsDTO> agenda;

	public String getJsonAgenda() throws Exception {
		ObjectMapper ow = new ObjectMapper();
		return ow.writeValueAsString(this.agenda);
	}

	public void setJsonAgenda(String agendaS) throws Exception {
		if (agendaS == null || agendaS.isEmpty()) return;

		ObjectMapper ow = new ObjectMapper();
		RecordsDTO[] agendaArr = ow.readValue(agendaS, RecordsDTO[].class);
		this.agenda = Arrays.asList(agendaArr);
	}

}