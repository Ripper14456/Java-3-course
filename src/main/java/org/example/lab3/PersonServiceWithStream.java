package org.example.lab3;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonServiceWithStream implements PersonServiceInterface {
    public List<Person> myList;

    public PersonServiceWithStream(List<Person> myList) {
        this.myList = myList;
    }

    public List<Person> getPersons() {
        return myList;
    }
    public void setPersons(List<Person> myList) {
        this.myList = myList;
    }


    public List<Person> getPersonByFirstName(String firstName)
    {
        return getPersons().stream().filter(getFirstName(firstName)).collect(Collectors.toList());
    }
    public List<Person> getPersonBySecondName(String secondName)
    {
        return getPersons().stream().filter(getSecondName(secondName)).collect(Collectors.toList());
    }
    public List<Person> getPersonsByCountry(String country)
    {
        return getPersons().stream().filter(getByCountry(country)).collect(Collectors.toList());
    }
    public List<Person> getPersonsByCity(String city)
    {
        return getPersons().stream().filter(getByCity(city)).collect(Collectors.toList());
    }

    private Predicate<Person> getFirstName (String firstName)
    {
        return person -> firstName.equals(person.getFirstName());
    }

    private Predicate<Person> getSecondName (String secondName)
    {
        return person -> secondName.equals(person.getSecondName());
    }

    private Predicate<Person> getByCountry (String country)
    {
        return person -> country.equals(person.getResidence().getCountry());
    }

    private Predicate<Person> getByCity (String city)
    {
        return person -> city.equals(person.getResidence().getCity());
    }
}
