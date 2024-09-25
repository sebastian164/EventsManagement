package com.innova.events.application.service.eventattendee;

import com.innova.events.domain.dto.EventAttendeeDTO;

import java.util.List;

public interface EventAttendeeService {
    List<EventAttendeeDTO> findAll();
    EventAttendeeDTO findById(Long id);
    EventAttendeeDTO save(EventAttendeeDTO eventAttendeeDTO);
    void delete(Long id);
}
