package com.innova.events.domain.model;

import lombok.Data;

@Data
public class EventImage {
    private Long id;
    private Event event;
    private Image image;
}