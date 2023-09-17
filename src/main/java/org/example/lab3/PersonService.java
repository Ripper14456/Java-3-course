package org.example.lab3;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    public List<Person> myList;

    public PersonService(List<Person> myList) {
        this.myList = myList;
    }

    public List<Person> getMyList() {
        return myList;
    }

    public void setMyList(List<Person> myList) {
        this.myList = myList;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "myList=" + myList +
                '}';
    }
    public List<Person> getPersonByFirstName(String firstName)
    {
        return getMyList().stream().filter(person -> firstName.equals(person.getFirstName())).collect(Collectors.toList());
    }
    public List<Person> getPersonBySecondName(String secondName)
    {
        return getMyList().stream().filter(person -> secondName.equals(person.getSecondName())).collect(Collectors.toList());
    }
    public List<Person> getPersonsByCountry(String country)
    {
        return getMyList().stream().filter(person -> country.equals(person.getResidence().getCountry())).collect(Collectors.toList());
    }
    public List<Person> getPersonsByCity(String city)
    {
        return getMyList().stream().filter(person -> city.equals(person.getResidence().getCity())).collect(Collectors.toList());
    }
}
