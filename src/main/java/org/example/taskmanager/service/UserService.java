package org.example.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PreRemove;
import org.example.taskmanager.domain.Task;
import org.example.taskmanager.domain.User;
import org.example.taskmanager.repository.TaskRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.UserDTO;
import org.example.taskmanager.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements CrudService<UserDTO, Long>{

    private final UserRepository userRepository;

   // private final TaskRepository taskRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, TaskRepository taskRepository, UserMapper userMapper){
        this.userRepository = userRepository;
  //      this.taskRepository = taskRepository;
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
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }

    @Override
    public boolean updateAll(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        userMapper.fullUpdate(userDTO, user);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean update(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        userMapper.partialUpdate(userDTO, user);
        userRepository.save(user);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        try {
            //taskRepository.updateToNullTasksByCreateById(id);
            //taskRepository.updateToNullTasksPerformers(id);
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }
    }
}
