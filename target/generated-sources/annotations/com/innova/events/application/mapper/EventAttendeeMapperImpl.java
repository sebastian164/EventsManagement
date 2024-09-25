package com.innova.events.application.mapper;

import com.innova.events.domain.dto.EventAttendeeDTO;
import com.innova.events.infrastructure.persistence.entity.EventAttendeeEntity;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
import com.innova.events.infrastructure.persistence.entity.UserEntity;
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
public class EventAttendeeMapperImpl implements EventAttendeeMapper {

    @Override
    public EventAttendeeDTO toEventAttendeeDTO(EventAttendeeEntity eventAttendee) {
        if ( eventAttendee == null ) {
            return null;
        }

        EventAttendeeDTO eventAttendeeDTO = new EventAttendeeDTO();

        eventAttendeeDTO.setId( eventAttendee.getId() );
        eventAttendeeDTO.setEventId( eventAttendeeEventId( eventAttendee ) );
        eventAttendeeDTO.setAttendeeId( eventAttendeeUserId( eventAttendee ) );
        if ( eventAttendee.getAttended() != null ) {
            eventAttendeeDTO.setAttended( eventAttendee.getAttended() );
        }

        return eventAttendeeDTO;
    }

    @Override
    public EventAttendeeEntity toEventAttendeeEntity(EventAttendeeDTO eventAttendeeDTO) {
        if ( eventAttendeeDTO == null ) {
            return null;
        }

        EventAttendeeEntity eventAttendeeEntity = new EventAttendeeEntity();

        eventAttendeeEntity.setEvent( eventAttendeeDTOToEventEntity( eventAttendeeDTO ) );
        eventAttendeeEntity.setUser( eventAttendeeDTOToUserEntity( eventAttendeeDTO ) );
        eventAttendeeEntity.setId( eventAttendeeDTO.getId() );
        eventAttendeeEntity.setAttended( eventAttendeeDTO.isAttended() );

        return eventAttendeeEntity;
    }

    @Override
    public List<EventAttendeeDTO> toEventAttendeeDTOs(List<EventAttendeeEntity> eventAttendees) {
        if ( eventAttendees == null ) {
            return null;
        }

        List<EventAttendeeDTO> list = new ArrayList<EventAttendeeDTO>( eventAttendees.size() );
        for ( EventAttendeeEntity eventAttendeeEntity : eventAttendees ) {
            list.add( toEventAttendeeDTO( eventAttendeeEntity ) );
        }

        return list;
    }

    private Long eventAttendeeEventId(EventAttendeeEntity eventAttendeeEntity) {
        if ( eventAttendeeEntity == null ) {
            return null;
        }
        EventEntity event = eventAttendeeEntity.getEvent();
        if ( event == null ) {
            return null;
        }
        Long id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long eventAttendeeUserId(EventAttendeeEntity eventAttendeeEntity) {
        if ( eventAttendeeEntity == null ) {
            return null;
        }
        UserEntity user = eventAttendeeEntity.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected EventEntity eventAttendeeDTOToEventEntity(EventAttendeeDTO eventAttendeeDTO) {
        if ( eventAttendeeDTO == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( eventAttendeeDTO.getEventId() );

        return eventEntity;
    }

    protected UserEntity eventAttendeeDTOToUserEntity(EventAttendeeDTO eventAttendeeDTO) {
        if ( eventAttendeeDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( eventAttendeeDTO.getAttendeeId() );

        return userEntity;
    }
}
