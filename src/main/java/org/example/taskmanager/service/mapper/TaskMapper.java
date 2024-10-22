package org.example.taskmanager.service.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.example.taskmanager.domain.*;
import org.example.taskmanager.service.dto.*;
import org.mapstruct.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper extends MapperEntity<Task, TaskDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(TaskDTO dto, @MappingTarget Task entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(TaskDTO dto, @MappingTarget Task entity);

    //////////////////////////////////////////////////

    @Named("customTaskMapper")
    @Mapping(target = "performers", source = "performers", qualifiedByName = "userMap")
    @Mapping(target = "createBy", source = "createBy", qualifiedByName = "userMap")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagMap")
    @Mapping(target = "status", source = "status", qualifiedByName = "statusMap")
    TaskDTO toDTO(Task task);

    @Named("LazyTaskMapper")
    @Mapping(target = "performers", ignore = true)
    @Mapping(target = "createBy", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "status", ignore = true)
    TaskDTO toLazyDTO(Task task);

    @Named("customTasksMapper")
    @IterableMapping(qualifiedByName = "LazyTaskMapper")
    List<TaskDTO> toDTOS(List<Task> tasks);

    @Named("userMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", ignore = true)
    UserDTO toDtoUser(User user);

    @Named("tagMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    TagDTO toDtoTag(Tag tag);

    @Named("statusMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    StatusDTO toDtoStatus(Status status);

/////////////////////////


    @Named("userDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", ignore = true)
    User toEntityUser(UserDTO userDTO);

    @Named("tagDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Tag toEntityTag(TagDTO tagDTO);

    @Named("statusDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    Status toEntityStatus(StatusDTO statusDTO);


    @Named("customTaskDTOMapper")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "performers", source = "performers", qualifiedByName = "userDTOMap")
    @Mapping(target = "createBy", source = "createBy", qualifiedByName = "userDTOMap")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagDTOMap")
    @Mapping(target = "status", source = "status", qualifiedByName = "statusDTOMap")
    Task toEntity(TaskDTO taskDTO);

    @Named("customTasksDTOMapper")
    @IterableMapping(qualifiedByName = "customTaskDTOMapper")
    List<Task> toEntities(List<TaskDTO> tasks);
}
