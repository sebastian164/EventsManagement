package com.innova.events.infrastructure.persistence.mapper;

import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import com.innova.events.domain.dto.EventCompanyDTO;
import com.innova.events.infrastructure.persistence.mapper.EventMapper;
import com.innova.events.infrastructure.persistence.mapper.CompanyMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventMapper.class, CompanyMapper.class})
public interface EventCompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event", target = "event"),
            @Mapping(source = "company", target = "company")
    })
    EventCompanyDTO toEventCompanyDTO(EventCompanyEntity eventCompany);

    @InheritInverseConfiguration
    EventCompanyEntity toEventCompanyEntity(EventCompanyDTO eventCompanyDTO);

    List<EventCompanyDTO> toEventCompanyDTOs(List<EventCompanyEntity> eventCompanies);
    List<EventCompanyEntity> toEventCompanyEntities(List<EventCompanyDTO> eventCompanies);
}