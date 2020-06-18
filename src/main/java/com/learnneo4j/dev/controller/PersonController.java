package com.learnneo4j.dev.controller;

import com.learnneo4j.dev.model.Person;
import com.learnneo4j.dev.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/graph")
public class PersonController {
    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/person/{name}")
    public List<Person> getPerson(@PathVariable("name") String name){
        return personService.getPerson(name);
    }

    @GetMapping("/person/all")
    public List<Person> getAll(){
        return personService.getAll();
    }
}
