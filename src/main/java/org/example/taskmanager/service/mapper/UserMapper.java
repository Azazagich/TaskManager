package org.example.taskmanager.service.mapper;

import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.service.dto.TaskDTO;
import org.example.taskmanager.service.dto.UserDTO;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

public interface UserMapper {

    User toUser(UserDTO userDTO);

    List<UserDTO> toUserDTOS(List<User> user);

    UserDTO toUserDTO(User user);

    Optional<UserDTO> toUserDTO(Optional<User> user);

    List<User> toUsers(List<UserDTO> userDTOS);
}