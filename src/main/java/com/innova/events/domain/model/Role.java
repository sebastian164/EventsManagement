package com.innova.events.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("roles")
public class Role {
    @Id
    private Long id;
    private String name;
}