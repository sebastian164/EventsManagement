package com.innova.events.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private List<UserDTO> users;
}