package com.innova.events.infrastructure.persistence.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "event_companies")
public class EventCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "id", nullable = false)
    private EventEntity event;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private CompanyEntity company;
}