package com.innova.events.application.mapper;

import com.innova.events.domain.dto.UserDTO;
import com.innova.events.infrastructure.persistence.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T18:58:05-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ImageMapper imageMapper;

    @Override
    public UserDTO toUserDTO(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setCompany( companyMapper.toCompanyDTO( user.getCompany() ) );
        userDTO.setRole( roleMapper.toRoleDTO( user.getRole() ) );
        userDTO.setProfileImage( imageMapper.toImageDTO( user.getProfileImage() ) );
        userDTO.setActive( user.getActive() );

        return userDTO;
    }

    @Override
    public UserEntity toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDTO.getId() );
        userEntity.setUsername( userDTO.getUsername() );
        userEntity.setEmail( userDTO.getEmail() );
        userEntity.setCompany( companyMapper.toCompanyEntity( userDTO.getCompany() ) );
        userEntity.setRole( roleMapper.toRoleEntity( userDTO.getRole() ) );
        userEntity.setProfileImage( imageMapper.toImageEntity( userDTO.getProfileImage() ) );
        userEntity.setActive( userDTO.getActive() );
        userEntity.setPassword( userDTO.getPassword() );

        return userEntity;
    }

    @Override
    public List<UserDTO> toUserDTOs(List<UserEntity> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( UserEntity userEntity : users ) {
            list.add( toUserDTO( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> toUserEntities(List<UserDTO> users) {
        if ( users == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( users.size() );
        for ( UserDTO userDTO : users ) {
            list.add( toUserEntity( userDTO ) );
        }

        return list;
    }
}
