package com.innova.events.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("companies")
public class Company {
    @Id
    private Long id;
    private String name;
    @Column("contact_email")
    private String contactEmail;
    private String phone;
}