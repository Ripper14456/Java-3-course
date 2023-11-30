package org.example.lab3;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceWithoutStream implements PersonServiceInterface {
    private List<Person> myList;

    public PersonServiceWithoutStream(List<Person> myList) {
        this.myList = myList;
    }

    public List<Person> getPersons() {
        return myList;
    }

    public void setPersons(List<Person> myList) {
        this.myList = myList;
    }

    public List<Person> getPersonByFirstName(String firstName) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (firstName.equals(person.getFirstName())) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonBySecondName(String secondName) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (secondName.equals(person.getSecondName())) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsByCountry(String country) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (country.equals(person.getResidence().getCountry())) {
                result.add(person);
            }
        }
        return result;
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> result = new ArrayList<>();
        for (Person person : myList) {
            if (city.equals(person.getResidence().getCity())) {
                result.add(person);
            }
        }
        return result;
    }
}
