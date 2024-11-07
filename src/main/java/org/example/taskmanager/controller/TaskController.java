package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.dto.TaskDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tasks")
@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
    private final static Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id){
        return taskService.getById(id);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping
    public List<TaskDTO> getAllTasks(){
        return taskService.getAll();
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PostMapping
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO){
        return taskService.save(taskDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PutMapping("/{id}")
    public TaskDTO fullUpdateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        return taskService.updateAll(id, taskDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @PatchMapping("/{id}")
    public TaskDTO partialUpdateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        return taskService.update(id, taskDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
    }
}
