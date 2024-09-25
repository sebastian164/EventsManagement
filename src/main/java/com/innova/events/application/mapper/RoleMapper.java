package com.innova.events.application.mapper;

import com.innova.events.domain.dto.RoleDTO;
import com.innova.events.infrastructure.persistence.entity.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name")
    })
    RoleDTO toRoleDTO(RoleEntity role);

    @InheritInverseConfiguration
    RoleEntity toRoleEntity(RoleDTO roleDTO);

    List<RoleDTO> toRoleDTOs(List<RoleEntity> roles);
    List<RoleEntity> toRoleEntities(List<RoleDTO> roles);
}