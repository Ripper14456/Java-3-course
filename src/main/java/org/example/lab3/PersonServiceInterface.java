package org.example.lab3;

import java.util.List;

public interface PersonServiceInterface {
    List<Person> getMyList();
    void setMyList(List<Person> myList);

    @Override
    String toString();

    List<Person> getPersonByFirstName(String firstName);
    List<Person> getPersonBySecondName(String secondName);
    List<Person> getPersonsByCountry(String country);
    List<Person> getPersonsByCity(String city);
}