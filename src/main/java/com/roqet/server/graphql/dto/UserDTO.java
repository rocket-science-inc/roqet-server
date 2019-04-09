package com.roqet.server.graphql.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	private Integer id;

	private String fullName;
}
