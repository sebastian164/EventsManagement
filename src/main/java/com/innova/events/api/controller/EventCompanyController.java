package com.innova.events.application.controller;

import com.innova.events.application.service.eventcompany.EventCompanyService;
import com.innova.events.domain.dto.EventCompanyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Company")
public class EventCompanyController {

    @Autowired
    private EventCompanyService eventCompanyService;

    @GetMapping
    public ResponseEntity<List<EventCompanyDTO>> getAllEventCompanies() {
        List<EventCompanyDTO> eventCompanies = eventCompanyService.findAll();
        return ResponseEntity.ok(eventCompanies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventCompanyDTO> getEventCompanyById(@PathVariable Long id) {
        EventCompanyDTO eventCompany = eventCompanyService.findById(id);
        return eventCompany != null ? ResponseEntity.ok(eventCompany) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EventCompanyDTO> createEventCompany(@RequestBody EventCompanyDTO eventCompanyDTO) {
        EventCompanyDTO savedEventCompany = eventCompanyService.save(eventCompanyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEventCompany);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventCompany(@PathVariable Long id) {
        eventCompanyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}