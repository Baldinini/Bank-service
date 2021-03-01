package com.example.bankservice.controllers;

import com.example.bankservice.model.Role;
import com.example.bankservice.model.User;
import com.example.bankservice.service.RoleService;
import com.example.bankservice.service.UserService;
import java.time.LocalDate;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void addRoles() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.RoleName.ADMIN);
        roleService.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setRoleName(Role.RoleName.USER);
        roleService.save(roleUser);
        User admin = new User();
        admin.setName("Bob Smith");
        admin.setDateOfBirth(LocalDate.of(2000, 10, 23));
        admin.setPhoneNumber("0987645327");
        admin.setPassword("1111");
        admin.setRoles(Set.of(roleAdmin));
        userService.create(admin);
    }
}
