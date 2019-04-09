package com.roqet.server.services.impl;

import static com.roqet.server.utils.ConvertDTO.convertIntoUserDto;
import static com.roqet.server.utils.ConvertDTO.convertUsers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.roqet.server.db.entities.User;
import com.roqet.server.db.repositories.UserRepository;
import com.roqet.server.graphql.dto.UserDTO;
import com.roqet.server.services.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> users(int count, int page) throws Exception {
		return this.getUsers(count, page);
	}

	public UserDTO user(int id) {
		return convertIntoUserDto(userRepository.findById(id).orElse(null));
	}

	private List<UserDTO> getUsers(int count, int page) throws Exception {
		Page<User> users = userRepository.findAll(PageRequest.of(page, count));

		return convertUsers(users.getContent());
	}
}
