package org.example.taskmanager.service;

import java.util.List;

public interface CrudService<DTO, ID extends Long> {

    DTO getById(ID id);

    List<DTO> getAll();

    DTO save(DTO dto) throws Exception;

    DTO updateAll(Long id, DTO dto);

    DTO update(Long id, DTO dto);

    void deleteById(ID id);
}
