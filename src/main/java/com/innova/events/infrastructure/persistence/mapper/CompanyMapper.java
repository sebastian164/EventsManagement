package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.CompanyEntity;
import com.innova.events.domain.dto.CompanyDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "contactEmail", target = "contactEmail"),
            @Mapping(source = "phone", target = "phone")
    })
    CompanyDTO toCompanyDTO(CompanyEntity company);

    @InheritInverseConfiguration
    CompanyEntity toCompanyEntity(CompanyDTO companyDTO);

    List<CompanyDTO> toCompanyDTOs(List<CompanyEntity> companies);
    List<CompanyEntity> toCompanyEntities(List<CompanyDTO> companies);
}