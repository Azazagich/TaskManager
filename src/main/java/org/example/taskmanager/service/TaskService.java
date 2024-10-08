package org.example.taskmanager.service;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TaskService implements CrudService<TaskDTO, Long>{

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper){
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO getById(Long id) {
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public List<TaskDTO> getAll() {
        return taskMapper.toDTOS(taskRepository.findAll());
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
            return taskMapper.toDTO(taskRepository.save(taskMapper.toEntity(taskDTO)));
    }

    @Override
    public boolean updateAll(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskMapper.fullUpdate(taskDTO, task);
        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean update(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskMapper.partialUpdate(taskDTO, task);
        taskRepository.save(task);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.getPerformers();
        taskRepository.deleteById(id);
    }
}
