package org.example.taskmanager.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.taskmanager.domain.Role;
import org.example.taskmanager.repository.RoleRepository;
import org.example.taskmanager.repository.UserRepository;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.mapper.RoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService implements CrudService<RoleDTO, Long>{
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final RoleMapper roleMapper;


    @Autowired
    public RoleService(RoleRepository roleRepository, UserRepository userRepository, RoleMapper roleMapper){
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDTO getById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();
        return roleMapper.toDTO(role);
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
    public RoleDTO updateAll(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleMapper.fullUpdate(roleDTO, role);
        roleRepository.save(role);
        return roleMapper.toDTO(roleRepository.findById(id).orElseThrow());
    }

    //partial update це перевірка на null(Partial Update (Часткове оновлення)
    //Часткове оновлення означає, що оновлюються лише ті поля, які явно задані у DTO. Поля, що мають значення null, не повинні перезаписувати існуючі дані у базі.)
    @Override
    public RoleDTO update(Long id, RoleDTO roleDTO) {
        Role role = roleRepository.findById(id).orElseThrow();
        roleMapper.partialUpdate(roleDTO, role);
        roleRepository.save(role);
        return roleMapper.toDTO(roleRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.updateToNullUsers(id);
            roleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("Role with id " + id + " not found");
        }
    }
}

