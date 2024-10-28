package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.RoleService;
import org.example.taskmanager.service.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Roles")
@RestController
@RequestMapping(path = "/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @Operation(summary = "")
    @GetMapping("/{id}")
    public RoleDTO getRole(@PathVariable Long id){
        return roleService.getById(id);
    }


    @GetMapping
    public List<RoleDTO> getAllRoles(){
        return roleService.getAll();
    }


    @PostMapping
    public RoleDTO saveRole(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }


    @PutMapping("/{id}")
    public RoleDTO fullUpdateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        return roleService.updateAll(id, roleDTO);

    }


    @PatchMapping("/{id}")
    public RoleDTO partialUpdateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        return roleService.update(id, roleDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteById(id);
    }
}
