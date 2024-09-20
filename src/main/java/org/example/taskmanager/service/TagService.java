package org.example.taskmanager.service;

import org.example.taskmanager.domain.Tag;
import org.example.taskmanager.repository.TagRepository;
import org.example.taskmanager.service.dto.TagDTO;
import org.example.taskmanager.service.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
public class TagService implements CrudService<TagDTO, Long>{

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    @Autowired
    public TagService(TagRepository tagRepository, TagMapper tagMapper){
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public TagDTO getById(Long id) {
        return tagMapper.toDTO(tagRepository.findById(id).orElseThrow());
    }

    @Override
    public List<TagDTO> getAll() {
        return tagMapper.toDTOS(tagRepository.findAll());
    }

    @Override
    public TagDTO save(TagDTO tagDTO) {
        return tagMapper.toDTO(tagRepository.save(tagMapper.toEntity(tagDTO)));
    }

    @Override
    public boolean updateAll(Long id, TagDTO tagDTO) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        tagMapper.fullUpdate(tagDTO, tag);
        tagRepository.save(tag);
        return true;
    }

    @Override
    public boolean update(Long id, TagDTO tagDTO) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        tagMapper.partialUpdate(tagDTO, tag);
        tagRepository.save(tag);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
