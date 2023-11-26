package org.example.lab4;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        Person.PersonBuilder obj1 = new Person.PersonBuilder();
        Person.PersonBuilder obj2 = new Person.PersonBuilder();
        Residence.ResidenceBuilder obj3 = new Residence.ResidenceBuilder();

        obj3.setCountry("Ukraine");
        obj3.setCity("Kyiv");
        obj3.setAddress("Golovna 167");

        obj1.setFirstName("Oleg");
        obj1.setSecondName("Demon");
        obj1.setDateOfBirth(LocalDate.of(2004,9,5));
        obj1.setResidence(obj3.build());

        obj2.setFirstName("Serge");
        obj2.setSecondName("Mazurka");
        obj2.setDateOfBirth(LocalDate.of(2003,2,23));
        obj2.setResidence(new Residence("Ukraine","Chernivtsi","Synogoge 322"));//null test

        System.out.println(obj1.build());
        System.out.println(obj2.build());
        System.out.println(obj3.build());
    }
}