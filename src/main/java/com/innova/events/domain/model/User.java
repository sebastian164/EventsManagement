package com.innova.events.domain.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Company company;
    private Role role;
    private Image profileImage;

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
}