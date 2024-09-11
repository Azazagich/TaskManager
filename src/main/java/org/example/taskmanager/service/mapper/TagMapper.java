package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.TagDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    Tag toTag(TagDTO tagDTO);

    TagDTO toTagDTO(Tag tag);

    List<TagDTO> toTagsDTOS(List<Tag> tags);

    List<Tag> toTags(List<TagDTO> tagDTO);
}
