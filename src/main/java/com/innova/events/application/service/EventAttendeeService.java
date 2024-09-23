package com.innova.events.application.service;

import com.innova.events.domain.model.EventAttendee;
import com.innova.events.domain.repository.EventAttendeeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventAttendeeService {

    private final EventAttendeeRepository eventAttendeeRepository;

    public EventAttendeeService(EventAttendeeRepository eventAttendeeRepository) {
        this.eventAttendeeRepository = eventAttendeeRepository;
    }

    public Flux<EventAttendee> findAll() {
        return eventAttendeeRepository.findAll();
    }

    public Mono<EventAttendee> findById(Long id) {
        return eventAttendeeRepository.findById(id);
    }

    public Mono<EventAttendee> save(EventAttendee eventAttendee) {
        return eventAttendeeRepository.save(eventAttendee);
    }

    public Mono<Void> deleteById(Long id) {
        return eventAttendeeRepository.deleteById(id);
    }
}
