package com.innova.events.application.mapper;

import com.innova.events.domain.dto.EventImageDTO;
import com.innova.events.infrastructure.persistence.entity.EventEntity;
import com.innova.events.infrastructure.persistence.entity.EventImageEntity;
import com.innova.events.infrastructure.persistence.entity.ImageEntity;
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
public class EventImageMapperImpl implements EventImageMapper {

    @Override
    public EventImageDTO toEventImageDTO(EventImageEntity eventImage) {
        if ( eventImage == null ) {
            return null;
        }

        EventImageDTO eventImageDTO = new EventImageDTO();

        eventImageDTO.setId( eventImage.getId() );
        eventImageDTO.setEventId( eventImageEventId( eventImage ) );
        eventImageDTO.setImageId( eventImageImageId( eventImage ) );
        eventImageDTO.setIsPrimary( eventImage.getIsPrimary() );

        return eventImageDTO;
    }

    @Override
    public EventImageEntity toEventImageEntity(EventImageDTO eventImageDTO) {
        if ( eventImageDTO == null ) {
            return null;
        }

        EventImageEntity eventImageEntity = new EventImageEntity();

        eventImageEntity.setEvent( eventImageDTOToEventEntity( eventImageDTO ) );
        eventImageEntity.setImage( eventImageDTOToImageEntity( eventImageDTO ) );
        eventImageEntity.setId( eventImageDTO.getId() );
        eventImageEntity.setIsPrimary( eventImageDTO.getIsPrimary() );

        return eventImageEntity;
    }

    @Override
    public List<EventImageDTO> toEventImageDTOs(List<EventImageEntity> eventImages) {
        if ( eventImages == null ) {
            return null;
        }

        List<EventImageDTO> list = new ArrayList<EventImageDTO>( eventImages.size() );
        for ( EventImageEntity eventImageEntity : eventImages ) {
            list.add( toEventImageDTO( eventImageEntity ) );
        }

        return list;
    }

    @Override
    public List<EventImageEntity> toEventImageEntities(List<EventImageDTO> eventImages) {
        if ( eventImages == null ) {
            return null;
        }

        List<EventImageEntity> list = new ArrayList<EventImageEntity>( eventImages.size() );
        for ( EventImageDTO eventImageDTO : eventImages ) {
            list.add( toEventImageEntity( eventImageDTO ) );
        }

        return list;
    }

    private Long eventImageEventId(EventImageEntity eventImageEntity) {
        if ( eventImageEntity == null ) {
            return null;
        }
        EventEntity event = eventImageEntity.getEvent();
        if ( event == null ) {
            return null;
        }
        Long id = event.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long eventImageImageId(EventImageEntity eventImageEntity) {
        if ( eventImageEntity == null ) {
            return null;
        }
        ImageEntity image = eventImageEntity.getImage();
        if ( image == null ) {
            return null;
        }
        Long id = image.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected EventEntity eventImageDTOToEventEntity(EventImageDTO eventImageDTO) {
        if ( eventImageDTO == null ) {
            return null;
        }

        EventEntity eventEntity = new EventEntity();

        eventEntity.setId( eventImageDTO.getEventId() );

        return eventEntity;
    }

    protected ImageEntity eventImageDTOToImageEntity(EventImageDTO eventImageDTO) {
        if ( eventImageDTO == null ) {
            return null;
        }

        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setId( eventImageDTO.getImageId() );

        return imageEntity;
    }
}
