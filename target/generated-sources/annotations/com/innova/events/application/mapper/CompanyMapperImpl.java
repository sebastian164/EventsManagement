package com.innova.events.application.mapper;

import com.innova.events.domain.dto.CompanyDTO;
import com.innova.events.infrastructure.persistence.entity.CompanyEntity;
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
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDTO toCompanyDTO(CompanyEntity company) {
        if ( company == null ) {
            return null;
        }

        CompanyDTO companyDTO = new CompanyDTO();

        companyDTO.setId( company.getId() );
        companyDTO.setName( company.getName() );
        companyDTO.setEmail( company.getContactEmail() );
        companyDTO.setPhone( company.getPhone() );

        return companyDTO;
    }

    @Override
    public CompanyEntity toCompanyEntity(CompanyDTO companyDTO) {
        if ( companyDTO == null ) {
            return null;
        }

        CompanyEntity companyEntity = new CompanyEntity();

        companyEntity.setId( companyDTO.getId() );
        companyEntity.setName( companyDTO.getName() );
        companyEntity.setContactEmail( companyDTO.getEmail() );
        companyEntity.setPhone( companyDTO.getPhone() );

        return companyEntity;
    }

    @Override
    public List<CompanyDTO> toCompanyDTOs(List<CompanyEntity> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyDTO> list = new ArrayList<CompanyDTO>( companies.size() );
        for ( CompanyEntity companyEntity : companies ) {
            list.add( toCompanyDTO( companyEntity ) );
        }

        return list;
    }

    @Override
    public List<CompanyEntity> toCompanyEntities(List<CompanyDTO> companies) {
        if ( companies == null ) {
            return null;
        }

        List<CompanyEntity> list = new ArrayList<CompanyEntity>( companies.size() );
        for ( CompanyDTO companyDTO : companies ) {
            list.add( toCompanyEntity( companyDTO ) );
        }

        return list;
    }
}
