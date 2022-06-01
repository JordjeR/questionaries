package com.homework.dto;

import lombok.Data;

@Data
public class RegisterUserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
