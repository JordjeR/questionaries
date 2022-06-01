package com.homework.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUserDto {
    private String username;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
