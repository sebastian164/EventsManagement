package com.innova.events.infrastructure.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@Entity
@Table(name = "events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true)
    private LocationEntity location;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EventCompanyEntity> companies;
}