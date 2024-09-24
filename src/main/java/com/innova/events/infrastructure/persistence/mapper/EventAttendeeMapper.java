package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import com.innova.events.domain.dto.EventAttendeeDTO;
import com.innova.events.infrastructure.persistence.mapper.EventMapper;
import com.innova.events.infrastructure.persistence.mapper.UserMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventMapper.class, UserMapper.class})
public interface EventAttendeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event", target = "event"),
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "attended", target = "attended")
    })
    EventAttendeeDTO toEventAttendeeDTO(EventAttendeeEntity eventAttendee);

    @InheritInverseConfiguration
    EventAttendeeEntity toEventAttendeeEntity(EventAttendeeDTO eventAttendeeDTO);

    List<EventAttendeeDTO> toEventAttendeeDTOs(List<EventAttendeeEntity> eventAttendees);
    List<EventAttendeeEntity> toEventAttendeeEntities(List<EventAttendeeDTO> eventAttendees);
}