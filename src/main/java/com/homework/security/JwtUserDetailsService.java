package com.homework.security;

import com.homework.entities.User;
import com.homework.security.jwt.JwtUser;
import com.homework.security.jwt.JwtUserFactory;
import com.homework.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("IN method loadUserByUsername user with username - " + username + " was not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN method loadUserByUsername jwtUser with this username- {} was loaded", jwtUser.getUsername());

        return jwtUser;
    }
}
