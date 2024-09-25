package com.innova.events.domain.model;

import lombok.Data;

@Data
public class EventCompany {
    private Long id;
    private Event event;
    private Company company;
}