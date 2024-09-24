package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventAttendeeDTO {
    private Long id;
    private Long eventId;
    private Long attendeeId;
    private boolean attended;
}