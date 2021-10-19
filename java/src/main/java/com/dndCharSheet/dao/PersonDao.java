package com.dndCharSheet.dao;

import com.dndCharSheet.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> getPersonList(int id);

    Person getCharacter(int id);

    Person createPerson(Person person);

    void deletePerson(int id);

    void healthUp(int id);

    void healthDown(int id);

    void longRestCharacter(int id);

}
