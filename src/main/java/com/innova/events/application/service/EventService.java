package com.innova.events.application.service;

import com.innova.events.domain.model.Event;
import com.innova.events.domain.repository.EventRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Flux<Event> findAll() {
        return eventRepository.findAll();
    }

    public Mono<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    public Mono<Event> save(Event event) {
        return eventRepository.save(event);
    }

    public Mono<Void> deleteById(Long id) {
        return eventRepository.deleteById(id);
    }
}
