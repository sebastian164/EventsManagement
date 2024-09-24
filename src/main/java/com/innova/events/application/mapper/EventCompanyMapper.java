package com.innova.events.application.mapper;

import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import com.innova.events.domain.dto.EventCompanyDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventCompanyMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "event.id", target = "eventId"),
            @Mapping(source = "company.id", target = "companyId")
    })
    EventCompanyDTO toEventCompanyDTO(EventCompanyEntity eventCompany);

    @InheritInverseConfiguration
    EventCompanyEntity toEventCompanyEntity(EventCompanyDTO eventCompanyDTO);

    List<EventCompanyDTO> toEventCompanyDTOs(List<EventCompanyEntity> eventCompanies);
    List<EventCompanyEntity> toEventCompanyEntities(List<EventCompanyDTO> eventCompanies);
}