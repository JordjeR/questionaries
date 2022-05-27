package com.homework;

import com.homework.entities.Person;
import com.homework.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    public App(PersonService personService) {
        this.personService = personService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    public final PersonService personService;

    @Override
    public void run(String... args) throws Exception {

        Person masha = new Person(1L, "Masha");
        Person andrey = new Person(2L, "Andrey");
        Person ivan = new Person(3L, "Ivan");

        personService.add(masha);
        personService.add(andrey);
        personService.add(ivan);
    }
}
