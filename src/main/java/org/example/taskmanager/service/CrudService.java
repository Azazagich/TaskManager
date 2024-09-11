package org.example.taskmanager.service;

import org.example.taskmanager.domain.Role;

import java.util.List;

public interface CrudService<DTO, ID extends Long> {

    DTO getById(ID id);

    List<DTO> getAll();

    DTO save(DTO dto);

    boolean updateAll(List<DTO> dtos);

    boolean update(ID id, DTO dto);

    void deleteById(ID id);
}
