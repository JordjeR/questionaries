package com.homework.controllers;

import com.homework.entities.Person;
import com.homework.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
    @PostMapping(path = "persons/add/"/*, consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}*/)
    public void addPerson(@RequestBody Person person) {
        personService.add(person);
    }

    @ResponseBody
    @GetMapping(path = "/persons")
    public List<Person> getListPersons() {
        return personService.findAll();
    }
}
