package com.innova.events.application.service;

import com.innova.events.domain.model.Location;
import com.innova.events.domain.repository.LocationRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Flux<Location> findAll() {
        return locationRepository.findAll();
    }

    public Mono<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    public Mono<Location> save(Location location) {
        return locationRepository.save(location);
    }

    public Mono<Void> deleteById(Long id) {
        return locationRepository.deleteById(id);
    }
}
