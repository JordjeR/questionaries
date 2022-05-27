package com.homework.services;

import com.homework.entities.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    List<Person> findAll();
}
