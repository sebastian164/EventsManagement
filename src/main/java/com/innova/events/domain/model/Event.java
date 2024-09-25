package com.innova.events.domain.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Event {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Location location;
    private List<EventCompany> eventCompanies;
    private List<EventAttendee> eventAttendees;
    private List<EventImage> eventImages;
}