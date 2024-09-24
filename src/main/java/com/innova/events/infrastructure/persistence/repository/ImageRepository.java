package com.innova.events.infrastructure.persistence.repository;

import com.innova.events.infrastructure.persistence.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}