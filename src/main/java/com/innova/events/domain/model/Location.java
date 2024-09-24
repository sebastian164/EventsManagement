package com.innova.events.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Location {
    private Long id;
    private String name;
    private String address;
    private List<Event> events;  // Relación con Event si es necesario
}