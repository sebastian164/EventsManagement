package com.innova.events.application.service;

import com.innova.events.domain.model.EventControl;
import com.innova.events.domain.repository.EventControlRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventControlService {

    private final EventControlRepository eventControlRepository;

    public EventControlService(EventControlRepository eventControlRepository) {
        this.eventControlRepository = eventControlRepository;
    }

    public Flux<EventControl> findAll() {
        return eventControlRepository.findAll();
    }

    public Mono<EventControl> findById(Long id) {
        return eventControlRepository.findById(id);
    }

    public Mono<EventControl> save(EventControl eventControl) {
        return eventControlRepository.save(eventControl);
    }

    public Mono<Void> deleteById(Long id) {
        return eventControlRepository.deleteById(id);
    }
}
