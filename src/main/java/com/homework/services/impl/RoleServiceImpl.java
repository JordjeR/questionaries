package com.homework.services.impl;

import com.homework.entities.Role;
import com.homework.repositories.RoleRepository;
import com.homework.services.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByName(String role) {
        Role userRole = roleRepository.findByName(role);

        if (userRole == null) {
            throw new IllegalArgumentException("IN method findByName role " + role + " was not found");
        }
        log.info("IN method findByName user with role " + role + " was found");
        return userRole;
    }
}
