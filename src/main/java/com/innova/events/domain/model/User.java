package com.innova.events.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String email;
    @Column("company_id")
    private Long companyId;
    @Column("role_id")
    private Long roleId;
}