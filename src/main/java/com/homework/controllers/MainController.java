package com.homework.controllers;

import com.homework.entities.Person;
import com.homework.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
//@CrossOrigin(origins = "*", maxAge = 3600)
public class MainController {

    private final PersonService personService;

    @Autowired
    public MainController(PersonService personService) {
        this.personService = personService;
    }

    @ResponseBody
    @PostMapping(path = "/persons/add/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPerson(@RequestBody Person person) {
        personService.add(person);
    }

    @ResponseBody
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(path = "/persons")
    public List<Person> getListPersons() {
        return personService.findAll();
    }
}
