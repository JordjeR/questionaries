package com.homework.controllers;

import com.homework.entities.Person;
import com.homework.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8088/")
public class MainController {

    private final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseBody
    @PostMapping(path = "persons/add/")
    public void addPerson(Person person) {
//        Person person = new Person(3L, name);
        System.out.println(person);
        personService.add(person);
    }

    @ResponseBody
    @GetMapping(path = "/persons")
    public List<Person> getPersons() {
        return personService.findAll();
    }
}
