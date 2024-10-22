package org.example.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TaskService implements CrudService<TaskDTO, Long>{

    private final UserService userService;

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(UserService userService, TaskRepository taskRepository, UserRepository userRepository, TaskMapper taskMapper){
        this.userService = userService;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDTO getById(Long id) {
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public List<TaskDTO> getAll() {
        List<Task> all = taskRepository.findAll();
        return taskMapper.toDTOS(all);
    }

    //#
    @Override
    public TaskDTO save(TaskDTO taskDTO) {
        Task dto = taskMapper.toEntity(taskDTO);
        Task save = taskRepository.save(dto);
        return taskMapper.toDTO(save);
    }

    @Override
    public TaskDTO updateAll(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskMapper.fullUpdate(taskDTO, task);
        taskRepository.save(task);
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public TaskDTO update(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id).orElseThrow();
        taskMapper.partialUpdate(taskDTO, task);
        taskRepository.save(task);
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        //task.getPerformers().forEach(performers -> performers.setTasks(null));
        try {
            taskRepository.deleteById(id);
        } catch (
            EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }
    }
}
