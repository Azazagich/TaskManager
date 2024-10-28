package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.TagService;
import org.example.taskmanager.service.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tags")
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
    public TagDTO fullUpdateRole(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.updateAll(id, tagDTO);
    }


    @PatchMapping("/{id}")
    public TagDTO partialUpdateRole(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.update(id, tagDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        tagService.deleteById(id);
    }
}
