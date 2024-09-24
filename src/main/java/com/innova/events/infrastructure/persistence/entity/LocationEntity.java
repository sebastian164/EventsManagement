package com.innova.events.infrastructure.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Set;

@Data
@Entity
@Table(name = "locations")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(precision = 9)
    private Double latitude;

    @Column(precision = 9)
    private Double longitude;
}