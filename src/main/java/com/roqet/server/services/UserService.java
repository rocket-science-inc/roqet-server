package com.roqet.server.services;

import java.util.List;

import com.roqet.server.graphql.dto.UserDTO;

public interface UserService {

	List<UserDTO> users(int count, int page) throws Exception;

	UserDTO user(int id);
}
