package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.UserService;
import org.example.taskmanager.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users")
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getById(id);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("/{id}")
    public UserDTO fullUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateAll(id, userDTO);
    }


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PatchMapping("/{id}")
    public UserDTO partialUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
