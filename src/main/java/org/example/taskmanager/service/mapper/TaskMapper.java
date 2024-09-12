package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.service.dto.TaskDTO;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper extends MapperEntity<Task, TaskDTO>{

}
