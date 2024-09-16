package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.service.dto.TagDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TagMapper extends MapperEntity<Tag, TagDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(TagDTO dto, @MappingTarget Tag entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(TagDTO dto, @MappingTarget Tag entity);
}
