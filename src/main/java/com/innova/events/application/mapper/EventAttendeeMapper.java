package com.innova.events.application.mapper;

import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import com.innova.events.domain.dto.EventAttendeeDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventAttendeeMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event.id", target = "eventId"),
            @Mapping(source = "user.id", target = "attendeeId"),
            @Mapping(source = "attended", target = "attended")
    })
    EventAttendeeDTO toEventAttendeeDTO(EventAttendeeEntity eventAttendee);

    @InheritInverseConfiguration
    EventAttendeeEntity toEventAttendeeEntity(EventAttendeeDTO eventAttendeeDTO);

    List<EventAttendeeDTO> toEventAttendeeDTOs(List<EventAttendeeEntity> eventAttendees);
}