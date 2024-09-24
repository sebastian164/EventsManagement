package com.innova.events.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
}