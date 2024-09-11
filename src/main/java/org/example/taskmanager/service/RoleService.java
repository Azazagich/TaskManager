package org.example.taskmanager.service;

import org.example.taskmanager.repository.RoleRepository;
import org.example.taskmanager.service.dto.RoleDTO;
import org.example.taskmanager.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        return roleMapper.toRoleDTO(roleRepository.findById(id)).orElseThrow();
    }

    @Override
    public List<RoleDTO> getAll() {
        return roleMapper.toRoleDTOS(roleRepository.findAll());
    }

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        return roleMapper.toRoleDTO(roleRepository.save(roleMapper.toRole(roleDTO)));
    }

    @Override
    public boolean updateAll(List<RoleDTO> roleDTOS) {
        boolean isUpdate = false;
        try {
            for (RoleDTO roleDTO : roleDTOS) {
                update(roleDTO.getId(), roleDTO);
            }
            isUpdate = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public boolean update(Long id, RoleDTO newRoleDTO) {
        boolean isUpdate = false;
        RoleDTO dto = new RoleDTO();
        dto.setId(id);
        dto.setName(newRoleDTO.getName());
        dto.setUsers(newRoleDTO.getUsers());
        try {
            save(dto);
            isUpdate = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
