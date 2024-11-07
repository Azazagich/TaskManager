package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.RoleService;
import org.example.taskmanager.service.dto.RoleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Roles")
@RestController
@RequestMapping(path = "/roles")
public class RoleController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping("/{id}")
    public RoleDTO getRole(@PathVariable Long id){
        return roleService.getById(id);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping
    public List<RoleDTO> getAllRoles(){
        return roleService.getAll();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public RoleDTO saveRole(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public RoleDTO fullUpdateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        return roleService.updateAll(id, roleDTO);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public RoleDTO partialUpdateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        return roleService.update(id, roleDTO);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteById(id);
    }
}
