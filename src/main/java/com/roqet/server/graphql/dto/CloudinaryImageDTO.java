package com.roqet.server.graphql.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CloudinaryImageDTO {

	private Integer bytes;
	private String created_at;
	private String etag;
	private String format;
	private Integer height;
	private String original_filename;
	private String placeholder;
	private String public_id;
	private String resource_type;
	private String secure_url;
	private String signature;
	private List<String> tags;
	private String type;
	private String url;
	private Long version;
	private Integer width;
}
