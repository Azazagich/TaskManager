package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);

    UserDTO toUserDTO(User user);

    List<UserDTO> toUserDTOS(List<User> user);

    List<User> toUsers(List<UserDTO> userDTOS);
}