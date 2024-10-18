package org.example.taskmanager.controller;

import org.example.taskmanager.service.TaskService;
import org.example.taskmanager.service.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping("/{id}")
    public TaskDTO getRole(@PathVariable Long id){
        return taskService.getById(id);
    }


    @GetMapping
    public List<TaskDTO> getAllRoles(){
        return taskService.getAll();
    }


    @PostMapping
    public TaskDTO saveRole(@RequestBody TaskDTO taskDTO){
        return taskService.save(taskDTO);
    }


    @PutMapping("/{id}")
    public TaskDTO fullUpdateRole(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        return taskService.updateAll(id, taskDTO);
    }


    @PatchMapping("/{id}")
    public TaskDTO partialUpdateRole(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        return taskService.update(id, taskDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        taskService.deleteById(id);
    }
}
