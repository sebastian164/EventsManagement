package com.innova.events.domain.repository;

import com.innova.events.domain.model.Location;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ReactiveCrudRepository<Location, Long> {
}