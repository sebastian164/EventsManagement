package com.innova.events.domain.dto;

import lombok.Data;
import java.util.List;

@Data
public class LocationDTO {

    private Long id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    }
