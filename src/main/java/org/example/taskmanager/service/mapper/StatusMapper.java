package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Status;
import org.example.taskmanager.service.dto.StatusDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface StatusMapper extends MapperEntity<Status, StatusDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(StatusDTO dto, @MappingTarget Status entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(StatusDTO dto, @MappingTarget Status entity);
}
