package org.example.taskmanager.controller;

import org.example.taskmanager.service.TagService;
import org.example.taskmanager.service.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }


    @GetMapping("/{id}")
    public TagDTO getRole(@PathVariable Long id){
        return tagService.getById(id);
    }


    @GetMapping
    public List<TagDTO> getAllRoles(){
        return tagService.getAll();
    }


    @PostMapping
    public TagDTO saveRole(@RequestBody TagDTO tagDTO){
        return tagService.save(tagDTO);
    }


    @PutMapping("/{id}")
    public boolean fullUpdateRole(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.updateAll(id, tagDTO);
    }


    @PatchMapping("/{id}")
    public boolean partialUpdateRole(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.update(id, tagDTO);
    }

    //TODO
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        tagService.deleteById(id);
    }
}
