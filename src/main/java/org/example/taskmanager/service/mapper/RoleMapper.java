package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Role;
import org.example.taskmanager.service.dto.RoleDTO;
import org.mapstruct.*;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface RoleMapper extends MapperEntity<Role, RoleDTO>{

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(RoleDTO dto, @MappingTarget Role entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(RoleDTO dto, @MappingTarget Role entity);
}
