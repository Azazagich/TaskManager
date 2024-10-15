package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.TagDTO;
import org.example.taskmanager.service.dto.TaskDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper extends MapperEntity<Status, StatusDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(StatusDTO dto, @MappingTarget Status entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(StatusDTO dto, @MappingTarget Status entity);

    @Named("taskDTOMap")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "body", source = "body")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "finishDate", source = "finishDate")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "createBy", source = "createBy")
    @Mapping(target = "performers", source = "performers")
    @Mapping(target = "tags", source = "tags")
    TaskDTO toDtoTask(Task task);

    @Named("customStatusMapper")
    @Mapping(target = "tasks", source = "tasks", qualifiedByName = "taskDTOMap")
    StatusDTO toDTO(Status status);

    @Named("customStatusesMapper")
    @IterableMapping(qualifiedByName = "customStatusMapper")
    List<StatusDTO> toDTOS(List<Status> statuses);

}
