package com.homework.services.impl;

import com.homework.entities.Role;
import com.homework.entities.Status;
import com.homework.entities.User;
import com.homework.repositories.RoleRepository;
import com.homework.repositories.UserRepository;
import com.homework.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roles);
        user.setStatus(Status.ACTIVE);
        user.setCreated(new Date());
        user.setUpdated(new Date());

        User registerUser = userRepository.save(user);

        log.info("IN method register user - {} successfully was saved", registerUser);

        return registerUser;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if (!allUsers.isEmpty()) {
            log.info("IN method findAllUsers - {} was loaded", allUsers.size());
            return allUsers;
        }

        return Collections.emptyList();
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            log.info("IN method delete user - {} was deleted", user.get().getUsername());
            userRepository.delete(user.get());
        }

        throw new IllegalArgumentException("IN method delete user with this id " + id + " was not found");
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        if (user != null) {
            log.info("IN method findUserByUsername user - {} was found", user.getUsername());
            return user;
        }

        throw new IllegalArgumentException("IN method findUserByUsername user with this username: " + username + " was not found");
    }

    @Override
    public User findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            log.info("IN method findUserById user with this id " + id + " was deleted");
            return user.get();
        }

        throw new IllegalArgumentException("IN method findUserById user with this id " + id + " was not deleted");
    }
}
