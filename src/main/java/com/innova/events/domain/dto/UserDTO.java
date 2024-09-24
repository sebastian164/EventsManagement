package com.innova.events.domain.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private CompanyDTO company;
    private RoleDTO role;
    private ImageDTO profileImage;
}