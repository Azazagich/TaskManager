package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.TagDTO;
import org.example.taskmanager.service.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task toTask(TaskDTO taskDTO);

    TaskDTO toTaskDTO(Task task);

    List<TaskDTO> toTaskDTOS(List<Task> task);

    List<Task> toTasks(List<TaskDTO> taskDTOS);
}
