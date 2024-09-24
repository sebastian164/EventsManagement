package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class EventCompanyDTO {
    private Long id;
    private Long eventId;
    private Long companyId;
}