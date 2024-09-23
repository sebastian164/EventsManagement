package com.innova.events.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
@Table("locations")
public class Location {
    @Id
    private Long id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
}