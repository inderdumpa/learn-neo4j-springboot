package com.learnneo4j.dev.service;

import com.learnneo4j.dev.model.Person;
import com.learnneo4j.dev.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String savePerson(Person person){
        personRepository.save(person);
        return "Person Info Saved!!";
    }

    @Override
    public List<Person> getPerson(String name){
        Iterable<Person> person = personRepository.findAll();
        List<Person> personList = new ArrayList<>();
        for(Person p: person){
            if(p.getName().contains(name))
                personList.add(p);
        }
        return personList;
    }

    @Override
    public List<Person> getAll(){
        List<Person> personList = new ArrayList<>();
        for(Person p: personRepository.findAll()){
            personList.add(p);
        }
        return personList;
    }
}
