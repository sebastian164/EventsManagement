package com.innova.events.api.controller;

import com.innova.events.application.service.eventattendee.EventAttendeeService;
import com.innova.events.domain.dto.EventAttendeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendees")
public class EventAttendeeController {

    @Autowired
    private EventAttendeeService eventAttendeeService;

    @GetMapping
    public ResponseEntity<List<EventAttendeeDTO>> getAllEventAttendees() {
        List<EventAttendeeDTO> eventAttendees = eventAttendeeService.findAll();
        return ResponseEntity.ok(eventAttendees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventAttendeeDTO> getEventAttendeeById(@PathVariable Long id) {
        EventAttendeeDTO eventAttendee = eventAttendeeService.findById(id);
        return eventAttendee != null ? ResponseEntity.ok(eventAttendee) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EventAttendeeDTO> createEventAttendee(@RequestBody EventAttendeeDTO eventAttendeeDTO) {
        EventAttendeeDTO savedEventAttendee = eventAttendeeService.save(eventAttendeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEventAttendee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventAttendee(@PathVariable Long id) {
        eventAttendeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}