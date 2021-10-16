package com.dndCharSheet.controller;

import com.dndCharSheet.dao.PersonDao;
import com.dndCharSheet.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
public class PersonController {

    private PersonDao personDao;

    public PersonController(PersonDao personDao){
        this.personDao = personDao;
    }

    @GetMapping("/characters/{id}")
    public List<Person> getUserCharacters(@PathVariable int id){
        return personDao.getPersonList(id);
    }

    @GetMapping("/character/{id}")
    public Person getCharacter(@PathVariable int id){
        return personDao.getCharacter(id);
    }

    @PostMapping("/character/create/{id}")
    public Person createCharacter(@RequestBody Person person){
        return personDao.createPerson(person);
    }

    @DeleteMapping("/character/delete/{id}")
    public void deleteCharacter(@PathVariable int id){
        personDao.deletePerson(id);
    }
}