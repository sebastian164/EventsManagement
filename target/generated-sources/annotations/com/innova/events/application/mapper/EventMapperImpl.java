package com.innova.events.application.mapper;

import com.innova.events.domain.dto.EventAttendeeDTO;
import com.innova.events.domain.dto.EventCompanyDTO;
import com.innova.events.domain.dto.EventDTO;
import com.innova.events.domain.dto.EventImageDTO;
import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import com.innova.events.infrastructure.persistence.entity.EventCompanyEntity;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
import com.innova.events.infrastructure.persistence.entity.EventImageEntity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T19:03:41-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private EventCompanyMapper eventCompanyMapper;
    @Autowired
    private EventAttendeeMapper eventAttendeeMapper;
    @Autowired
    private EventImageMapper eventImageMapper;

    @Override
    public EventDTO toEventDTO(EventEntity event) {
        if ( event == null ) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId( event.getId() );
        eventDTO.setName( event.getName() );
        eventDTO.setDescription( event.getDescription() );
        eventDTO.setDate( map( event.getDate() ) );
        eventDTO.setLocation( locationMapper.toLocationDTO( event.getLocation() ) );
        eventDTO.setEventCompanies( eventCompanyEntitySetToEventCompanyDTOList( event.getCompanies() ) );
        eventDTO.setEventAttendees( eventAttendeeEntitySetToEventAttendeeDTOList( event.getAttendees() ) );
        eventDTO.setEventImages( eventImageEntitySetToEventImageDTOList( event.getImages() ) );

        return eventDTO;
    }

    @Override
    public EventEntity toEventEntity(EventDTO eventDTO) {
        if ( eventDTO == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( eventDTO.getId() );
        eventEntity.setName( eventDTO.getName() );
        eventEntity.setDescription( eventDTO.getDescription() );
        eventEntity.setDate( map( eventDTO.getDate() ) );
        eventEntity.setLocation( locationMapper.toLocationEntity( eventDTO.getLocation() ) );
        eventEntity.setCompanies( eventCompanyDTOListToEventCompanyEntitySet( eventDTO.getEventCompanies() ) );
        eventEntity.setAttendees( eventAttendeeDTOListToEventAttendeeEntitySet( eventDTO.getEventAttendees() ) );
        eventEntity.setImages( eventImageDTOListToEventImageEntitySet( eventDTO.getEventImages() ) );

        return eventEntity;
    }

    @Override
    public List<EventDTO> toEventDTOs(List<EventEntity> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDTO> list = new ArrayList<EventDTO>( events.size() );
        for ( EventEntity eventEntity : events ) {
            list.add( toEventDTO( eventEntity ) );
        }

        return list;
    }

    protected List<EventCompanyDTO> eventCompanyEntitySetToEventCompanyDTOList(Set<EventCompanyEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<EventCompanyDTO> list = new ArrayList<EventCompanyDTO>( set.size() );
        for ( EventCompanyEntity eventCompanyEntity : set ) {
            list.add( eventCompanyMapper.toEventCompanyDTO( eventCompanyEntity ) );
        }

        return list;
    }

    protected List<EventAttendeeDTO> eventAttendeeEntitySetToEventAttendeeDTOList(Set<EventAttendeeEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<EventAttendeeDTO> list = new ArrayList<EventAttendeeDTO>( set.size() );
        for ( EventAttendeeEntity eventAttendeeEntity : set ) {
            list.add( eventAttendeeMapper.toEventAttendeeDTO( eventAttendeeEntity ) );
        }

        return list;
    }

    protected List<EventImageDTO> eventImageEntitySetToEventImageDTOList(Set<EventImageEntity> set) {
        if ( set == null ) {
            return null;
        }

        List<EventImageDTO> list = new ArrayList<EventImageDTO>( set.size() );
        for ( EventImageEntity eventImageEntity : set ) {
            list.add( eventImageMapper.toEventImageDTO( eventImageEntity ) );
        }

        return list;
    }

    protected Set<EventCompanyEntity> eventCompanyDTOListToEventCompanyEntitySet(List<EventCompanyDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<EventCompanyEntity> set = new LinkedHashSet<EventCompanyEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( EventCompanyDTO eventCompanyDTO : list ) {
            set.add( eventCompanyMapper.toEventCompanyEntity( eventCompanyDTO ) );
        }

        return set;
    }

    protected Set<EventAttendeeEntity> eventAttendeeDTOListToEventAttendeeEntitySet(List<EventAttendeeDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<EventAttendeeEntity> set = new LinkedHashSet<EventAttendeeEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( EventAttendeeDTO eventAttendeeDTO : list ) {
            set.add( eventAttendeeMapper.toEventAttendeeEntity( eventAttendeeDTO ) );
        }

        return set;
    }

    protected Set<EventImageEntity> eventImageDTOListToEventImageEntitySet(List<EventImageDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<EventImageEntity> set = new LinkedHashSet<EventImageEntity>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( EventImageDTO eventImageDTO : list ) {
            set.add( eventImageMapper.toEventImageEntity( eventImageDTO ) );
        }

        return set;
    }
}
