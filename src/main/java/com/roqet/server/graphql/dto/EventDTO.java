package com.roqet.server.graphql.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class EventDTO {

	private Integer id;

	private String title;

	private UserDTO organizer;

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
		if (agendaS == null || agendaS.isEmpty()) {
			this.agenda = Collections.emptyList();
			return;
		}

		ObjectMapper ow = new ObjectMapper();
		RecordsDTO[] agendaArr = ow.readValue(agendaS, RecordsDTO[].class);
		this.agenda = agendaArr == null ? new ArrayList<>() : Arrays.asList(agendaArr);
	}

}