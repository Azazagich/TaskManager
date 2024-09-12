package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.service.dto.TagDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TagMapper extends MapperEntity<Tag, TagDTO>{

}
