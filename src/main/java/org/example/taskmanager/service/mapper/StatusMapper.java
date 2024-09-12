package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.service.dto.StatusDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StatusMapper extends MapperEntity<Status, StatusDTO>{

}
