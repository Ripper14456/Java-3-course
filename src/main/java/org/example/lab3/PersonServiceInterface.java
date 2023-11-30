package org.example.lab3;

import java.util.List;

public interface PersonServiceInterface {
    List<Person> getPersons();
    void setPersons(List<Person> myList);

    List<Person> getPersonByFirstName(String firstName);
    List<Person> getPersonBySecondName(String secondName);
    List<Person> getPersonsByCountry(String country);
    List<Person> getPersonsByCity(String city);
}