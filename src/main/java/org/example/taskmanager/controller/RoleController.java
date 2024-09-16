package org.example.taskmanager.controller;

import org.example.taskmanager.service.RoleService;
import org.example.taskmanager.service.dto.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/role")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }


    @GetMapping
    public RoleDTO getRole(@RequestParam Long id){
        return roleService.getById(id);
    }


    @GetMapping(path = "/allRoles")
    public List<RoleDTO> getAllRoles(){
        return roleService.getAll();
    }


    @PostMapping
    public RoleDTO saveRole(@RequestBody RoleDTO roleDTO){
        return roleService.save(roleDTO);
    }

    //ToDO
    @PutMapping
    public boolean fullUpdateRole(@RequestParam Long id, @RequestBody RoleDTO roleDTO){
        return roleService.updateAll(id, roleDTO);
    }

    //ToDO
    @PatchMapping
    public boolean partialUpdateRole(@RequestParam Long id, @RequestBody RoleDTO roleDTO){
        return roleService.updateAll(id, roleDTO);
    }

    //ToDO
    @DeleteMapping
    public boolean deleteRole(@RequestParam Long id){
        return roleService.deleteById(id);
    }
}
