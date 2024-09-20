package org.example.taskmanager.service;

import org.example.taskmanager.domain.User;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.UserDTO;
import org.example.taskmanager.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements CrudService<UserDTO, Long>{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
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
        userRepository.deleteById(id);
    }
}
