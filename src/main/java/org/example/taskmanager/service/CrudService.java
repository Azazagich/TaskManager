package org.example.taskmanager.service;

import java.util.List;

public interface CrudService<DTO, ID extends Long> {

    DTO getById(ID id);

    List<DTO> getAll();

    DTO save(DTO dto);

    boolean updateAll(DTO dtos);

    boolean update(DTO dto);

    void deleteById(ID id);
}
