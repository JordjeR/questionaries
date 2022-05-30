package com.homework;

import com.homework.entities.Person;
import com.homework.entities.Role;
import com.homework.entities.Status;
import com.homework.entities.User;
import com.homework.repositories.RoleRepository;
import com.homework.services.PersonService;
import com.homework.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    /*@Autowired
    public App(PersonService personService, UserService userService, RoleRepository roleRepository) {
        this.personService = personService;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /*private final PersonService personService;
    private final UserService userService;

    private final RoleRepository roleRepository;*/

    @Override
    public void run(String... args) throws Exception {
/*
        Person masha = new Person(1L, "Masha");
        Person andrey = new Person(2L, "Andrey");
        Person ivan = new Person(3L, "Ivan");

        personService.add(masha);
        personService.add(andrey);
        personService.add(ivan);*/
    }
}
