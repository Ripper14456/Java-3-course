package org.example.lab4;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        Person.PersonBuilder obj1 = new Person.PersonBuilder();

        Residence r = new Residence.ResidenceBuilder()
                .setCountry("Ukraine")
                .setCity("Kyiv")
                .setAddress("Golovna 167").build();

        Person p = new Person.PersonBuilder()
        .setFirstName("Oleg")
        .setSecondName("Demon")
        .setDateOfBirth(LocalDate.of(2004,9,5))
        .setResidence(r).build();

        obj1.setFirstName("Serge");
        obj1.setSecondName("Mazurka");
        obj1.setDateOfBirth(LocalDate.of(2003,2,23));
        obj1.setResidence(new Residence("Ukraine","Chernivtsi","Synogoge 322"));//null test

        System.out.println(obj1.build());
        System.out.println(p);
    }
}