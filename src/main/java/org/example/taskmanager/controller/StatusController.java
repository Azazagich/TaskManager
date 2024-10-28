package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.StatusService;
import org.example.taskmanager.service.dto.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Statuses")
@RestController
@RequestMapping(path = "/statuses")
public class StatusController {

    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService){
        this.statusService = statusService;
    }


    @GetMapping("/{id}")
    public StatusDTO getRole(@PathVariable Long id){
        return statusService.getById(id);
    }


    @GetMapping
    public List<StatusDTO> getAllRoles(){
        return statusService.getAll();
    }


    @PostMapping
    public StatusDTO saveRole(@RequestBody StatusDTO statusDTO){
        return statusService.save(statusDTO);
    }


    @PutMapping("/{id}")
    public StatusDTO fullUpdateRole(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
        return statusService.updateAll(id, statusDTO);
    }


    @PatchMapping("/{id}")
    public StatusDTO partialUpdateRole(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
        return statusService.update(id, statusDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        statusService.deleteById(id);
    }
}
