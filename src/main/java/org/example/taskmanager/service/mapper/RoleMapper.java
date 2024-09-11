package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Role;
import org.example.taskmanager.domain.Status;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.dto.StatusDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role toRole(RoleDTO roleDTO);

    List<Role> toRoles(List<RoleDTO> rolesDTO);

    RoleDTO toRoleDTO(Role role);

    List<RoleDTO> toRoleDTOS(List<Role> roles);
}
