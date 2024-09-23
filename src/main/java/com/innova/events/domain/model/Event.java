package com.innova.events.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

@Data
@Table("events")
public class Event {
    @Id
    private Long id;
    private String name;
    private String date;
    @Column("location_id")
    private Long locationId;
    private String description;
}