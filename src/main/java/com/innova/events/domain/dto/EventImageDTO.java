package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventImageDTO {
    private Long id;
    private EventDTO event;
    private ImageDTO image;
}