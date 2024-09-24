package com.innova.events.application.mapper;

import com.innova.events.domain.dto.LocationDTO;
import com.innova.events.infrastructure.persistence.entity.LocationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "latitude", target = "latitude"),
            @Mapping(source = "longitude", target = "longitude")
    })
    LocationDTO toLocationDTO(LocationEntity location);

    @InheritInverseConfiguration
    LocationEntity toLocationEntity(LocationDTO locationDTO);

    List<LocationDTO> toLocationDTOs(List<LocationEntity> locations);
}