package com.wms.warehouse.service;
import com.wms.warehouse.entity.RoleEntity;
import com.wms.warehouse.entity.UserEntity;
import com.wms.warehouse.repository.RoleRepository;
import com.wms.warehouse.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final private UserRepository userRepository;
    final private RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }
    public UserEntity updateUser (Long id,String rolename) {
        UserEntity user = userRepository.findById(id).orElse(null);
        RoleEntity role = roleRepository.findByRolename(rolename);
        user.setRoleEntity(role);
        return userRepository.save(user);
    }
}
