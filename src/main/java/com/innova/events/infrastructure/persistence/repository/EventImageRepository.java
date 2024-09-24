package com.innova.events.infrastructure.persistence.repository;

import com.innova.events.infrastructure.persistence.entity.EventImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventImageRepository extends JpaRepository<EventImageEntity, Long> {
}