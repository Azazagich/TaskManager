package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.TagDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TagMapper {

    Tag toTag(TagDTO tagDTO);

    List<Tag> toTags(List<TagDTO> tagDTO);

    TagDTO toTagDTO(Tag tag);

    Optional<TagDTO> toTagDTO(Optional<Tag> tag);

    List<TagDTO> toTagsDTOS(List<Tag> tags);
}
