package com.innova.events.application.service.user;

import com.innova.events.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
