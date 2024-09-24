package com.innova.events.application.mapper;

import com.innova.events.domain.dto.EventDTO;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = "spring", uses = {LocationMapper.class, EventCompanyMapper.class, EventAttendeeMapper.class, EventImageMapper.class})
public interface EventMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "location", target = "location"),
            @Mapping(source = "companies", target = "eventCompanies"),
            @Mapping(source = "attendees", target = "eventAttendees"),
            @Mapping(source = "images", target = "eventImages")
    })
    EventDTO toEventDTO(EventEntity event);

    @InheritInverseConfiguration
    EventEntity toEventEntity(EventDTO eventDTO);

    List<EventDTO> toEventDTOs(List<EventEntity> events);
    default Timestamp map(LocalDateTime date) {
        return date != null ? Timestamp.valueOf(date) : null;
    }

    default LocalDateTime map(Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }
}
