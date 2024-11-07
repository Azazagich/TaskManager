package org.example.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.UserDTO;
import org.example.taskmanager.service.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements CrudService<UserDTO, Long> {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final RoleService roleService;

    private final TaskRepository taskRepository;


    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService, TaskRepository taskRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.taskRepository = taskRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public List<UserDTO> getAll() {
        return userMapper.toDTOS(userRepository.findAll());
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserDTO dto = userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
        roleService.update(userDTO.getRole().getId(), userDTO.getRole());
        return dto;
    }

    @Override
    public UserDTO updateAll(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        userMapper.fullUpdate(userDTO, user);
        userRepository.save(user);
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        userMapper.partialUpdate(userDTO, user);
        userRepository.save(user);
        return userMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Long id) {
        try {
//            User user = userRepository.findById(id).orElseThrow();
//            user.getTasks().forEach(task -> task.setPerformers(null));
            taskRepository.updateToNullCreateBy(id);
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }
    }
}
