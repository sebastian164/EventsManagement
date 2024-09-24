package com.innova.events.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false)
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "profile_image_id")
    private ImageEntity profileImage;
}