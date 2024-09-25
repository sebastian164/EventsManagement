package com.innova.events.application.service.event;

import com.innova.events.application.mapper.EventMapper;
import com.innova.events.domain.dto.EventDTO;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
import com.innova.events.infrastructure.persistence.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    @Lazy
    private EventMapper eventMapper;

    @Override
    public List<EventDTO> findAll() {
        return eventMapper.toEventDTOs(eventRepository.findAll());
    }

    @Override
    public EventDTO findById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toEventDTO)
                .orElse(null);
    }

    @Override
    public EventDTO save(EventDTO eventDTO) {
        EventEntity eventEntity = eventMapper.toEventEntity(eventDTO);
        EventEntity savedEvent = eventRepository.save(eventEntity);
        return eventMapper.toEventDTO(savedEvent);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}