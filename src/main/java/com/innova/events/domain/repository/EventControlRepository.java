package com.innova.events.domain.repository;

import com.innova.events.domain.model.EventControl;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventControlRepository extends ReactiveCrudRepository<EventControl, Long> {
}