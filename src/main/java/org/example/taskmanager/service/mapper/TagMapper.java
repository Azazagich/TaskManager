package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.TagDTO;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper extends MapperEntity<Tag, TagDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(TagDTO dto, @MappingTarget Tag entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(TagDTO dto, @MappingTarget Tag entity);

    @Named("taskDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "finishDate", source = "finishDate")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "performers", source = "performers")
    @Mapping(target = "tags", source = "tags")
    TaskDTO toDtoTask(Task task);


    @Named("customTagMapper")
    @Mapping(target = "tasks", source = "tasks", qualifiedByName = "taskDTOMap")
    TagDTO toDTO(Tag tag);


    @Named("customTagsMapper")
    @IterableMapping(qualifiedByName = "customTagMapper")
    List<TagDTO> toDTOS(List<Tag> tags);
}
