package com.innova.events.infrastructure.persistence.repository;

import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAttendeeRepository extends JpaRepository<EventAttendeeEntity, Long> {
}