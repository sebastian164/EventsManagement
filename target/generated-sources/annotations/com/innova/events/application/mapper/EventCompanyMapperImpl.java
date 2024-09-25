package com.innova.events.application.mapper;

import com.innova.events.domain.dto.EventCompanyDTO;
import com.innova.events.infrastructure.persistence.entity.CompanyEntity;
import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
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
public class EventCompanyMapperImpl implements EventCompanyMapper {

    @Override
    public EventCompanyDTO toEventCompanyDTO(EventCompanyEntity eventCompany) {
        if ( eventCompany == null ) {
            return null;
        }

        EventCompanyDTO eventCompanyDTO = new EventCompanyDTO();

        eventCompanyDTO.setId( eventCompany.getId() );
        eventCompanyDTO.setEventId( eventCompanyEventId( eventCompany ) );
        eventCompanyDTO.setCompanyId( eventCompanyCompanyId( eventCompany ) );

        return eventCompanyDTO;
    }

    @Override
    public EventCompanyEntity toEventCompanyEntity(EventCompanyDTO eventCompanyDTO) {
        if ( eventCompanyDTO == null ) {
            return null;
        }

        EventCompanyEntity eventCompanyEntity = new EventCompanyEntity();

        eventCompanyEntity.setEvent( eventCompanyDTOToEventEntity( eventCompanyDTO ) );
        eventCompanyEntity.setCompany( eventCompanyDTOToCompanyEntity( eventCompanyDTO ) );
        eventCompanyEntity.setId( eventCompanyDTO.getId() );

        return eventCompanyEntity;
    }

    @Override
    public List<EventCompanyDTO> toEventCompanyDTOs(List<EventCompanyEntity> eventCompanies) {
        if ( eventCompanies == null ) {
            return null;
        }

        List<EventCompanyDTO> list = new ArrayList<EventCompanyDTO>( eventCompanies.size() );
        for ( EventCompanyEntity eventCompanyEntity : eventCompanies ) {
            list.add( toEventCompanyDTO( eventCompanyEntity ) );
        }

        return list;
    }

    @Override
    public List<EventCompanyEntity> toEventCompanyEntities(List<EventCompanyDTO> eventCompanies) {
        if ( eventCompanies == null ) {
            return null;
        }

        List<EventCompanyEntity> list = new ArrayList<EventCompanyEntity>( eventCompanies.size() );
        for ( EventCompanyDTO eventCompanyDTO : eventCompanies ) {
            list.add( toEventCompanyEntity( eventCompanyDTO ) );
        }

        return list;
    }

    private Long eventCompanyEventId(EventCompanyEntity eventCompanyEntity) {
        if ( eventCompanyEntity == null ) {
            return null;
        }
        EventEntity event = eventCompanyEntity.getEvent();
        if ( event == null ) {
            return null;
        }
        Long id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long eventCompanyCompanyId(EventCompanyEntity eventCompanyEntity) {
        if ( eventCompanyEntity == null ) {
            return null;
        }
        CompanyEntity company = eventCompanyEntity.getCompany();
        if ( company == null ) {
            return null;
        }
        Long id = company.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected EventEntity eventCompanyDTOToEventEntity(EventCompanyDTO eventCompanyDTO) {
        if ( eventCompanyDTO == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( eventCompanyDTO.getEventId() );

        return eventEntity;
    }

    protected CompanyEntity eventCompanyDTOToCompanyEntity(EventCompanyDTO eventCompanyDTO) {
        if ( eventCompanyDTO == null ) {
            return null;
        }

        CompanyEntity companyEntity = new CompanyEntity();

        companyEntity.setId( eventCompanyDTO.getCompanyId() );

        return companyEntity;
    }
}
