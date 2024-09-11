package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.service.dto.TaskDTO;
import org.mapstruct.Mapper;


import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {

    Task toTask(TaskDTO taskDTO);

    List<Task> toTasks(List<TaskDTO> taskDTOS);

    TaskDTO toTaskDTO(Task task);

    Optional<TaskDTO> toTaskDTO(Optional<Task> tag);

    List<TaskDTO> toTaskDTOS(List<Task> task);
}
