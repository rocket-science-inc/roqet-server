package com.roqet.server.db.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.roqet.server.db.entities.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

	Page<Event> findAll(Pageable pageable);
}
