package com.innova.events.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime date;
    private LocationDTO location;
    private List<EventCompanyDTO> eventCompanies;
    private List<EventAttendeeDTO> eventAttendees;
    private List<EventImageDTO> eventImages;
}
