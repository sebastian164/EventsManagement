package com.innova.events.domain.model;

import lombok.Data;

@Data
public class EventAttendee {
    private Long id;
    private Event event;
    private User attendee;
}