package com.homework.services;

import com.homework.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    void delete(Long id);

    User register(User user);

    User findUserByUsername(String username);

    User findUserById(Long id);
}
