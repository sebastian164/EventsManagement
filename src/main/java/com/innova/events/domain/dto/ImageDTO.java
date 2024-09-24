package com.innova.events.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ImageDTO {
    private Long id;
    private String url;
    private String description;
    private LocalDateTime uploadedAt;
}