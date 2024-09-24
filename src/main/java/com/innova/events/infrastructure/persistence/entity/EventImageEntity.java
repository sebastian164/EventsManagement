package com.innova.events.infrastructure.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "event_images")
public class EventImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = false)
    private ImageEntity image;

    @Column(nullable = false)
    private Boolean isPrimary = false;
}