package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventCompanyDTO {
    private Long id;
    private EventDTO event;
    private CompanyDTO company;
}