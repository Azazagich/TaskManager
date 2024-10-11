package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Role;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface RoleMapper extends MapperEntity<Role, RoleDTO>{

//    @MappingTarget
//    RoleDTO toDTO(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(RoleDTO dto, @MappingTarget Role entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(RoleDTO dto, @MappingTarget Role entity);

    @Named("customRoleMapper")
    @Mapping(target = "users", source = "users", qualifiedByName = "userId")
    RoleDTO toDTO(Role role);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", source = "role"/*ignore = true*/)
    UserDTO toDtoUserId(User user);
}


