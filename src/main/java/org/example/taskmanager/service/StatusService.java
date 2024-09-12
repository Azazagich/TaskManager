package org.example.taskmanager.service;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.repository.StatusRepository;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class StatusService implements CrudService<StatusDTO, Long>{

    private final StatusRepository statusRepository;

    private final StatusMapper statusMapper;

    @Autowired
    public StatusService(StatusRepository statusRepository, StatusMapper statusMapper){
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public StatusDTO getById(Long id) {
        return statusMapper.toDTO(statusRepository.findById(id)).orElseThrow();
    }

    @Override
    public List<StatusDTO> getAll() {
        return statusMapper.toDTOS(statusRepository.findAll());
    }

    @Override
    public StatusDTO save(StatusDTO statusDTO) {
        return statusMapper.toDTO(statusRepository.save(statusMapper.toEntity(statusDTO)));
    }

    @Override
    public boolean updateAll(StatusDTO statusDTO) {
        Status status = statusRepository.findById(statusDTO.getId()).orElseThrow();
        statusMapper.fullUpdate(statusDTO, status);
        statusRepository.save(status);
        return true;
    }

    @Override
    public boolean update(StatusDTO statusDTO) {
        Status status = statusRepository.findById(statusDTO.getId()).orElseThrow();
        statusMapper.partialUpdate(statusDTO, status);
        statusRepository.save(status);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        statusRepository.deleteById(id);
    }
}
