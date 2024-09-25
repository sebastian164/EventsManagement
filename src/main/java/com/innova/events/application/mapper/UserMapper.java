package com.innova.events.application.mapper;

import com.innova.events.domain.dto.UserDTO;
import com.innova.events.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class, RoleMapper.class, ImageMapper.class})
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "company", target = "company"),
            @Mapping(source = "role", target = "role"),
            @Mapping(source = "profileImage", target = "profileImage"),
            @Mapping(source = "active", target = "active"),
            @Mapping(target = "password", ignore = true)
    })
    UserDTO toUserDTO(UserEntity user);

    @InheritInverseConfiguration
    UserEntity toUserEntity(UserDTO userDTO);

    List<UserDTO> toUserDTOs(List<UserEntity> users);
    List<UserEntity> toUserEntities(List<UserDTO> users);
}
