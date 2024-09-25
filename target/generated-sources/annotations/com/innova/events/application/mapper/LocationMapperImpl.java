package com.innova.events.application.mapper;

import com.innova.events.domain.dto.LocationDTO;
import com.innova.events.infrastructure.persistence.entity.LocationEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T19:03:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public LocationDTO toLocationDTO(LocationEntity location) {
        if ( location == null ) {
            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId( location.getId() );
        locationDTO.setName( location.getName() );
        locationDTO.setAddress( location.getAddress() );
        locationDTO.setLatitude( location.getLatitude() );
        locationDTO.setLongitude( location.getLongitude() );

        return locationDTO;
    }

    @Override
    public LocationEntity toLocationEntity(LocationDTO locationDTO) {
        if ( locationDTO == null ) {
            return null;
        }

        LocationEntity locationEntity = new LocationEntity();

        locationEntity.setId( locationDTO.getId() );
        locationEntity.setName( locationDTO.getName() );
        locationEntity.setAddress( locationDTO.getAddress() );
        locationEntity.setLatitude( locationDTO.getLatitude() );
        locationEntity.setLongitude( locationDTO.getLongitude() );

        return locationEntity;
    }

    @Override
    public List<LocationDTO> toLocationDTOs(List<LocationEntity> locations) {
        if ( locations == null ) {
            return null;
        }

        List<LocationDTO> list = new ArrayList<LocationDTO>( locations.size() );
        for ( LocationEntity locationEntity : locations ) {
            list.add( toLocationDTO( locationEntity ) );
        }

        return list;
    }
}
