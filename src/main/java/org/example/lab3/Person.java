package org.example.lab3;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String firstName;
    private String secondName;
    private int age;
    private Residence residence;

    public Person(String firstName, String secondName, int age, Residence residence) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.residence = residence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(residence, person.residence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age, residence);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", residence=" + residence +
                '}';
    }

    @Override
    public int compareTo(Person obj) {
        return this.age - obj.age;
    }
}
