package org.example.taskmanager.controller;

import org.example.taskmanager.service.UserService;
import org.example.taskmanager.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getById(id);
    }


    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }


    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }


    @PutMapping("/{id}")
    public boolean fullUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.updateAll(id, userDTO);
    }


    @PatchMapping("/{id}")
    public boolean partialUpdateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        return userService.update(id, userDTO);
    }

    //TODO
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }
}
