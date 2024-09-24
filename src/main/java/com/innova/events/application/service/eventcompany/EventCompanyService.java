package com.innova.events.application.service.eventcompany;

import com.innova.events.domain.dto.EventCompanyDTO;

import java.util.List;

public interface EventCompanyService {
    List<EventCompanyDTO> findAll();
    EventCompanyDTO findById(Long id);
    EventCompanyDTO save(EventCompanyDTO eventCompanyDTO);
    void delete(Long id);
}
