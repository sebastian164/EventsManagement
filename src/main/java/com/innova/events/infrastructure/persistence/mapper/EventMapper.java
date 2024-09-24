package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.EventEntity;
import com.innova.events.domain.dto.EventDTO;
import com.innova.events.infrastructure.persistence.mapper.LocationMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface EventMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "location", target = "location"),
            @Mapping(source = "description", target = "description")
    })
    EventDTO toEventDTO(EventEntity event);

    @InheritInverseConfiguration
    EventEntity toEventEntity(EventDTO eventDTO);

    List<EventDTO> toEventDTOs(List<EventEntity> events);
    List<EventEntity> toEventEntities(List<EventDTO> events);
}