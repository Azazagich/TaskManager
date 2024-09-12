package org.example.taskmanager.service;

import org.example.taskmanager.domain.Role;
import org.example.taskmanager.repository.RoleRepository;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService implements CrudService<RoleDTO, Long>{

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Autowired
    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public RoleDTO getById(Long id) {
        return roleMapper.toDTO(roleRepository.findById(id)).orElseThrow();
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
    public boolean updateAll(RoleDTO roleDTO) {
        Role role = roleRepository.findById(roleDTO.getId()).orElseThrow();
        roleMapper.fullUpdate(roleDTO, role);
        roleRepository.save(role);
        return true;
    }

    //partial update це перевірка на null(Partial Update (Часткове оновлення)
    //Часткове оновлення означає, що оновлюються лише ті поля, які явно задані у DTO. Поля, що мають значення null, не повинні перезаписувати існуючі дані у базі.)
    @Override
    public boolean update(RoleDTO roleDTO) {
        Role role = roleRepository.findById(roleDTO.getId()).orElseThrow();
        roleMapper.partialUpdate(roleDTO, role);
        roleRepository.save(role);
        return true;
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
