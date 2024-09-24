package com.innova.events.application.mapper;

import com.innova.events.infrastructure.persistence.entity.EventImageEntity;
import com.innova.events.domain.dto.EventImageDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventImageMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event.id", target = "eventId"),
            @Mapping(source = "image.id", target = "imageId"),
            @Mapping(source = "isPrimary", target = "isPrimary")
    })
    EventImageDTO toEventImageDTO(EventImageEntity eventImage);

    @InheritInverseConfiguration
    EventImageEntity toEventImageEntity(EventImageDTO eventImageDTO);

    List<EventImageDTO> toEventImageDTOs(List<EventImageEntity> eventImages);
    List<EventImageEntity> toEventImageEntities(List<EventImageDTO> eventImages);
}
