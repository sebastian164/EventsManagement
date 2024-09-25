package com.innova.events.application.service.location;

import com.innova.events.domain.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    List<LocationDTO> findAll();
    LocationDTO findById(Long id);
    LocationDTO save(LocationDTO locationDTO);
    void delete(Long id);
}
