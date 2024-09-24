package com.innova.events.application.service.event;

import com.innova.events.domain.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> findAll();
    EventDTO findById(Long id);
    EventDTO save(EventDTO eventDTO);
    void delete(Long id);
}
