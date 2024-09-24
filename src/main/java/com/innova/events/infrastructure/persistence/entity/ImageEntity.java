package com.innova.events.infrastructure.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "images")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String path;

    @Column(name = "alt_text", length = 255)
    private String altText;

    @Column(name = "uploaded_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime uploadedAt;
}