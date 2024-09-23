package com.innova.events.domain.repository;

import com.innova.events.domain.model.EventAttendee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAttendeeRepository extends ReactiveCrudRepository<EventAttendee, Long> {
}