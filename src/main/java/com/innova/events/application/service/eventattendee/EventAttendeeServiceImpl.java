package com.innova.events.application.service.eventattendee;

import com.innova.events.application.mapper.EventAttendeeMapper;
import com.innova.events.domain.dto.EventAttendeeDTO;
import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import com.innova.events.infrastructure.persistence.repository.EventAttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EventAttendeeServiceImpl implements EventAttendeeService {
    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;
    @Autowired
    private EventAttendeeMapper eventAttendeeMapper;

    @Override
    public List<EventAttendeeDTO> findAll() {
        return eventAttendeeMapper.toEventAttendeeDTOs(eventAttendeeRepository.findAll());
    }

    @Override
    public EventAttendeeDTO findById(Long id) {
        return eventAttendeeRepository.findById(id)
                .map(eventAttendeeMapper::toEventAttendeeDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event Attendee not found"));
    }

    @Override
    public EventAttendeeDTO save(EventAttendeeDTO eventAttendeeDTO) {
        EventAttendeeEntity eventAttendee = eventAttendeeMapper.toEventAttendeeEntity(eventAttendeeDTO);
        EventAttendeeEntity savedEventAttendee = eventAttendeeRepository.save(eventAttendee);
        return eventAttendeeMapper.toEventAttendeeDTO(savedEventAttendee);
    }

    @Override
    public void delete(Long id) {
        eventAttendeeRepository.deleteById(id);
    }
}