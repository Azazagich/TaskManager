package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.StatusService;
import org.example.taskmanager.service.dto.StatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping("/{id}")
    public StatusDTO getStatus(@PathVariable Long id){
        return statusService.getById(id);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping
    public List<StatusDTO> getAllStatuses(){
        return statusService.getAll();
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PostMapping
    public StatusDTO saveStatus(@RequestBody StatusDTO statusDTO){
        return statusService.save(statusDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PutMapping("/{id}")
    public StatusDTO fullUpdateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
        return statusService.updateAll(id, statusDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PatchMapping("/{id}")
    public StatusDTO partialUpdateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
        return statusService.update(id, statusDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @DeleteMapping("/{id}")
    public void deleteStatus(@PathVariable Long id){
        statusService.deleteById(id);
    }
}
