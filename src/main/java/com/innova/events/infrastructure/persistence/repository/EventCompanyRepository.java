package com.innova.events.infrastructure.persistence.repository;

import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventCompanyRepository extends JpaRepository<EventCompanyEntity, Long> {
}