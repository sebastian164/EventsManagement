package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventAttendeeDTO {
    private Long id;
    private EventDTO event;
    private UserDTO attendee;
}