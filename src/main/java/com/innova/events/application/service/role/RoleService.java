package com.innova.events.application.service.role;

import com.innova.events.domain.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> findAll();
    RoleDTO findById(Long id);
    RoleDTO save(RoleDTO roleDTO);
    void delete(Long id);
}
