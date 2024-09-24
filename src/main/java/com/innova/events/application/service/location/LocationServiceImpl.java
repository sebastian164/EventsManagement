package com.innova.events.application.service.location;

import com.innova.events.domain.dto.LocationDTO;
import com.innova.events.infrastructure.persistence.entity.LocationEntity;
import com.innova.events.infrastructure.persistence.repository.LocationRepository;
import com.innova.events.application.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    @Lazy
    private LocationMapper locationMapper;

    @Override
    public List<LocationDTO> findAll() {
        return locationMapper.toLocationDTOs(locationRepository.findAll());
    }

    @Override
    public LocationDTO findById(Long id) {
        return locationRepository.findById(id)
                .map(locationMapper::toLocationDTO)
                .orElse(null);
    }

    @Override
    public LocationDTO save(LocationDTO locationDTO) {
        LocationEntity locationEntity = locationMapper.toLocationEntity(locationDTO);
        LocationEntity savedLocation = locationRepository.save(locationEntity);
        return locationMapper.toLocationDTO(savedLocation);
    }

    @Override
    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
