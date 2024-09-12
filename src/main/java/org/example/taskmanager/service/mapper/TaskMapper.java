package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.service.dto.TaskDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface TaskMapper extends MapperEntity<Task, TaskDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(TaskDTO dto, @MappingTarget Task entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(TaskDTO dto, @MappingTarget Task entity);
}
