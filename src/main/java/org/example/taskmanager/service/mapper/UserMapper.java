package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends MapperEntity<User, UserDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(UserDTO dto, @MappingTarget User entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(UserDTO dto, @MappingTarget User entity);


    @Named("taskDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "finishDate", source = "finishDate")
//    @Mapping(target = "createBy", source = "createBy")
//    @Mapping(target = "status", source = "status")
//    @Mapping(target = "performers", source = "performers")
    TaskDTO toDtoTask(Task task);


    @Named("customTaskMapper")
    @Mapping(target = "tasks", source = "tasks", qualifiedByName = "taskDTOMap")
    UserDTO toDTO(User user);


    @Named("customTasksMapper")
    @IterableMapping(qualifiedByName = "customTaskMapper")
    List<UserDTO> toDTOS(List<User> users);
}