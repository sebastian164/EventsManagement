package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.ImageEntity;
import com.innova.events.domain.dto.ImageDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "path", target = "path"),
            @Mapping(source = "altText", target = "altText"),
            @Mapping(source = "uploadedAt", target = "uploadedAt")
    })
    ImageDTO toImageDTO(ImageEntity image);

    @InheritInverseConfiguration
    ImageEntity toImageEntity(ImageDTO imageDTO);

    List<ImageDTO> toImageDTOs(List<ImageEntity> images);
    List<ImageEntity> toImageEntities(List<ImageDTO> images);
}