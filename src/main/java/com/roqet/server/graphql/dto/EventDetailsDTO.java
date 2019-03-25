package com.roqet.server.graphql.dto;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EventDetailsDTO {

	private Integer id;

	private String title;

	private Integer organizer;

	private String description;

	private String ticket_link;

	private LocationDTO location;

	private String image;

	private EventTime time;

	private List<AgendaPartDTO> agenda;

	public String getJsonAgenda() throws Exception {
		ObjectMapper ow = new ObjectMapper();
		return ow.writeValueAsString(this.agenda);
	}

	public void setJsonAgenda(String agendaS) throws Exception {
		if (agendaS == null || agendaS.isEmpty()) return;

		ObjectMapper ow = new ObjectMapper();
		AgendaPartDTO[] agendaArr = ow.readValue(agendaS, AgendaPartDTO[].class);
		this.agenda = Arrays.asList(agendaArr);
	}
}