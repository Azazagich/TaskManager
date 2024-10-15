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
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

@Mapper(componentModel = "spring")
public interface RoleMapper extends MapperEntity<Role, RoleDTO>{

//    @MappingTarget
//    RoleDTO toDTO(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(RoleDTO dto, @MappingTarget Role entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
    void fullUpdate(RoleDTO dto, @MappingTarget Role entity);

    //to dto mapper
//    @Named("userDTOMap")
//    @BeanMapping(ignoreByDefault = true)
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "firstName", source = "firstName")
//    @Mapping(target = "lastName", source = "lastName")
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "password", source = "password")
//    UserDTO toDtoUser(User user);


    // to dto role mapper
//    @Named("customRoleMapper")
//    @Mapping(target = "users", source = "users", qualifiedByName = "userDTOMap")
//    RoleDTO toDTO(Role role);


    //to dtos role mapper
//    @Named("customRolesMapper")
//    @IterableMapping(qualifiedByName = "customRoleMapper")
//    List<RoleDTO> toDTOS(List<Role> roles);
//
//
//    @Named("customRoleDTOMapper")
//    @Mapping(target = "users", source = "users", qualifiedByName = "userMap")
//    Role toEntity(RoleDTO roleDTO);
//
//
//    @Named("customRolesDTOMapper")
//    @IterableMapping(qualifiedByName = "customRoleDTOMapper")
//    List<Role> toEntities(List<RoleDTO> roleDTO);
//
//
//    @Named("userMap")
//    @BeanMapping(ignoreByDefault = true)
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "firstName", source = "firstName")
//    @Mapping(target = "lastName", source = "lastName")
//    @Mapping(target = "email", source = "email")
//    @Mapping(target = "password", source = "password")
//    User toUserEntity(UserDTO user);

//    List<Role> toEntities(List<RoleDTO> rolesDTO);
}


