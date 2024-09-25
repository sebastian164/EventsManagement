package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventImageDTO {
    private Long id;
    private Long eventId;
    private Long imageId;
    private Boolean isPrimary;
}