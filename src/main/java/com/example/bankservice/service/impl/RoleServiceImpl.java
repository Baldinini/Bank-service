package com.example.bankservice.service.impl;

import com.example.bankservice.model.Role;
import com.example.bankservice.repository.RoleRepository;
import com.example.bankservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findRoleByRoleName(Role.RoleName.valueOf(name)).get();
    }
}
