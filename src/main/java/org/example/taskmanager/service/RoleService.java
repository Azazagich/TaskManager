package org.example.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.taskmanager.domain.Role;
import org.example.taskmanager.repository.RoleRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

import org.example.taskmanager.domain.User;

@Service
@Transactional
public class RoleService implements CrudService<RoleDTO, Long>{

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;
    private final UserRepository userRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper, UserRepository userRepository){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.userRepository = userRepository;
    }

    @Override
    public RoleDTO getById(Long id) {
        return roleMapper.toDTO(roleRepository.findById(id).orElseThrow());
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleMapper.toDTOS(roleRepository.findAll());
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return roleMapper.toDTO(roleRepository.save(roleMapper.toEntity(roleDTO)));
    }

    //full update це без перевірки на null просто сетається Full Update (Повне оновлення)
    //Повне оновлення означає, що всі поля DTO повинні перезаписати відповідні поля сутності, навіть якщо вони мають значення null.
    @Override
    public boolean updateAll(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleMapper.fullUpdate(roleDTO, role);
        roleRepository.save(role);
        return true;
    }

    //partial update це перевірка на null(Partial Update (Часткове оновлення)
    //Часткове оновлення означає, що оновлюються лише ті поля, які явно задані у DTO. Поля, що мають значення null, не повинні перезаписувати існуючі дані у базі.)
    @Override
    public boolean update(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleMapper.partialUpdate(roleDTO, role);
        roleRepository.save(role);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();
        Set<User> users =  role.getUsers();
        users.iterator().forEachRemaining(user -> user.setRole(null));
        userRepository.saveAll(users);
        try {
            roleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }

    }
}

