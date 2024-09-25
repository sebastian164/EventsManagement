package com.innova.events.application.service.role;

import com.innova.events.application.mapper.RoleMapper;
import com.innova.events.domain.dto.RoleDTO;
import com.innova.events.infrastructure.persistence.entity.RoleEntity;
import com.innova.events.infrastructure.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<RoleDTO> findAll() {
        return roleMapper.toRoleDTOs(roleRepository.findAll());
    }

    @Override
    public RoleDTO findById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::toRoleDTO)
                .orElse(null);
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        RoleEntity roleEntity = roleMapper.toRoleEntity(roleDTO);
        RoleEntity savedRole = roleRepository.save(roleEntity);
        return roleMapper.toRoleDTO(savedRole);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
