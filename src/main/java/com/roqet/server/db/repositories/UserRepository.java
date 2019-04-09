package com.roqet.server.db.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.roqet.server.db.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Page<User> findAll(Pageable pageable);
}
