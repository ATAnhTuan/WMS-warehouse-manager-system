package com.wms.warehouse.service;

import com.wms.warehouse.entity.RoleEntity;
import com.wms.warehouse.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {


    final private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleEntity> getAllRole() {
        return roleRepository.findAll();
    }

    public RoleEntity createRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public Optional<RoleEntity> getRole(Long id) {
        return roleRepository.findById(id);
    }

    public RoleEntity updateRole(Long id, RoleEntity roleEntity) {
        RoleEntity existingRole = roleRepository.findById(id).orElse(null);
        if (existingRole != null) {
            existingRole.setRolename(roleEntity.getRolename());
            return roleRepository.save(existingRole);
        } else {
            throw new NotFoundException("Role not found with id: " + id);
        }
    }

    @Transactional
    public RoleEntity deleteRole(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Not found this id: " + id));
        roleRepository.deleteById(id);
        return roleEntity;
    }
}
