package com.innova.events.application.mapper;

import com.innova.events.domain.dto.RoleDTO;
import com.innova.events.infrastructure.persistence.entity.RoleEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T19:03:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toRoleDTO(RoleEntity role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );

        return roleDTO;
    }

    @Override
    public RoleEntity toRoleEntity(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        RoleEntity roleEntity = new RoleEntity();

        roleEntity.setId( roleDTO.getId() );
        roleEntity.setName( roleDTO.getName() );

        return roleEntity;
    }

    @Override
    public List<RoleDTO> toRoleDTOs(List<RoleEntity> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( RoleEntity roleEntity : roles ) {
            list.add( toRoleDTO( roleEntity ) );
        }

        return list;
    }

    @Override
    public List<RoleEntity> toRoleEntities(List<RoleDTO> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleEntity> list = new ArrayList<RoleEntity>( roles.size() );
        for ( RoleDTO roleDTO : roles ) {
            list.add( toRoleEntity( roleDTO ) );
        }

        return list;
    }
}
