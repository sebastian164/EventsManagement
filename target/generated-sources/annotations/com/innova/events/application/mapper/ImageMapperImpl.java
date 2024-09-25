package com.innova.events.application.mapper;

import com.innova.events.domain.dto.ImageDTO;
import com.innova.events.infrastructure.persistence.entity.ImageEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-24T18:55:17-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDTO toImageDTO(ImageEntity image) {
        if ( image == null ) {
            return null;
        }

        ImageDTO imageDTO = new ImageDTO();

        imageDTO.setId( image.getId() );
        imageDTO.setUrl( image.getPath() );
        imageDTO.setDescription( image.getAltText() );
        imageDTO.setUploadedAt( image.getUploadedAt() );

        return imageDTO;
    }

    @Override
    public ImageEntity toImageEntity(ImageDTO imageDTO) {
        if ( imageDTO == null ) {
            return null;
        }

        ImageEntity imageEntity = new ImageEntity();

        imageEntity.setId( imageDTO.getId() );
        imageEntity.setPath( imageDTO.getUrl() );
        imageEntity.setAltText( imageDTO.getDescription() );
        imageEntity.setUploadedAt( imageDTO.getUploadedAt() );

        return imageEntity;
    }

    @Override
    public List<ImageDTO> toImageDTOs(List<ImageEntity> images) {
        if ( images == null ) {
            return null;
        }

        List<ImageDTO> list = new ArrayList<ImageDTO>( images.size() );
        for ( ImageEntity imageEntity : images ) {
            list.add( toImageDTO( imageEntity ) );
        }

        return list;
    }

    @Override
    public List<ImageEntity> toImageEntities(List<ImageDTO> images) {
        if ( images == null ) {
            return null;
        }

        List<ImageEntity> list = new ArrayList<ImageEntity>( images.size() );
        for ( ImageDTO imageDTO : images ) {
            list.add( toImageEntity( imageDTO ) );
        }

        return list;
    }
}
