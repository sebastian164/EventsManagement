package com.innova.events.domain.model;

import lombok.Data;

@Data
public class Company {
    private Long id;
    private String name;
    private String address;
    private String phone;
}