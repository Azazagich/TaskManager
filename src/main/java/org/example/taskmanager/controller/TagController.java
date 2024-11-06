package org.example.taskmanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.taskmanager.service.TagService;
import org.example.taskmanager.service.dto.TagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping("/{id}")
    public TagDTO getTag(@PathVariable Long id){
        return tagService.getById(id);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @GetMapping
    public List<TagDTO> getAllTags(){
        return tagService.getAll();
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PostMapping
    public TagDTO saveTag(@RequestBody TagDTO tagDTO){
        return tagService.save(tagDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PutMapping("/{id}")
    public TagDTO fullUpdateTag(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.updateAll(id, tagDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @PatchMapping("/{id}")
    public TagDTO partialUpdateTag(@PathVariable Long id, @RequestBody TagDTO tagDTO){
        return tagService.update(id, tagDTO);
    }


    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('USER')")
    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id){
        tagService.deleteById(id);
    }
}
