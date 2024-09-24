package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.EventImageEntity;
import com.innova.events.domain.dto.EventImageDTO;
import com.innova.events.infrastructure.persistence.mapper.EventMapper;
import com.innova.events.infrastructure.persistence.mapper.ImageMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventMapper.class, ImageMapper.class})
public interface EventImageMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event", target = "event"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "uploadedAt", target = "uploadedAt")
    })
    EventImageDTO toEventImageDTO(EventImageEntity eventImage);

    @InheritInverseConfiguration
    EventImageEntity toEventImageEntity(EventImageDTO eventImageDTO);

    List<EventImageDTO> toEventImageDTOs(List<EventImageEntity> eventImages);
    List<EventImageEntity> toEventImageEntities(List<EventImageDTO> eventImages);
}
