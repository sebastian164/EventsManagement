package com.innova.events.application.service.eventcompany;

import com.innova.events.application.mapper.EventCompanyMapper;
import com.innova.events.domain.dto.EventCompanyDTO;
import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import com.innova.events.infrastructure.persistence.repository.EventCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventCompanyServiceImpl implements EventCompanyService {

    @Autowired
    private EventCompanyRepository eventCompanyRepository;

    @Autowired
    @Lazy
    private EventCompanyMapper eventCompanyMapper;

    @Override
    public List<EventCompanyDTO> findAll() {
        return eventCompanyMapper.toEventCompanyDTOs(eventCompanyRepository.findAll());
    }

    @Override
    public EventCompanyDTO findById(Long id) {
        return eventCompanyRepository.findById(id)
                .map(eventCompanyMapper::toEventCompanyDTO)
                .orElse(null);
    }

    @Override
    public EventCompanyDTO save(EventCompanyDTO eventCompanyDTO) {
        EventCompanyEntity eventCompanyEntity = eventCompanyMapper.toEventCompanyEntity(eventCompanyDTO);
        EventCompanyEntity savedEventCompany = eventCompanyRepository.save(eventCompanyEntity);
        return eventCompanyMapper.toEventCompanyDTO(savedEventCompany);
    }

    @Override
    public void delete(Long id) {
        eventCompanyRepository.deleteById(id);
    }
}
