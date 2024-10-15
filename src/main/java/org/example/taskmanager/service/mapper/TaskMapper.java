package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.TagDTO;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper extends MapperEntity<Task, TaskDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(TaskDTO dto, @MappingTarget Task entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(TaskDTO dto, @MappingTarget Task entity);


    @Named("customTaskMapper")
    @Mapping(target = "performers", source = "performers", qualifiedByName = "userDTOMap")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagDTOMap")
    @Mapping(target = "status", source = "status", qualifiedByName = "statusDTOMap")
    TaskDTO toDTO(Task task);

    @Named("customTasksMapper")
    @IterableMapping(qualifiedByName = "customTaskMapper")
    List<TaskDTO> toDTOS(List<Task> tasks);

    @Named("userDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    UserDTO toDtoUser(User user);

    @Named("tagDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    TagDTO toDtoTag(Tag tag);

    @Named("statusDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    StatusDTO toDtoStatus(Status status);

}
