package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends MapperEntity<User, UserDTO>{

}