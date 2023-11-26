package org.example.lab3;

import java.time.LocalDate;
import java.util.*;


public class Demo {
    public static void main(String[] args) {
        TreeSet<Person> person1 = new TreeSet<>();
        Person.PersonBuilder obj1 = new Person.PersonBuilder();
        Person.PersonBuilder obj2 = new Person.PersonBuilder();
        Person.PersonBuilder obj3 = new Person.PersonBuilder();

        obj1.setFirstName("Oleg");
        obj1.setSecondName("Demon");
        obj1.setDateOfBirth(LocalDate.of(2004, 9, 5));
        obj1.setResidence(new Residence("Ukraine", "Kyiv", "Golovna 167"));

        obj2.setFirstName("Serge");
        obj2.setSecondName("Mazurka");
        obj2.setDateOfBirth(LocalDate.of(2003, 2, 23));
        obj2.setResidence(new Residence("Ukraine", "Chernivtsi", "Synogoge 322"));

        obj3.setFirstName("Bogdan");
        obj3.setSecondName("Mazurka");
        obj3.setDateOfBirth(LocalDate.of(2003, 6, 6));
        obj3.setResidence(new Residence("Ukraine", "Kyiv", "Kyivska 12"));

        person1.add(obj1.build());
        person1.add(obj2.build());
        person1.add(obj3.build());
        for (Person p : person1) {
            System.out.println(p);
        }
        System.out.println("\n");


        List<Person> person2 = new ArrayList<>();
        Person.PersonBuilder obj4 = new Person.PersonBuilder();
        Person.PersonBuilder obj5 = new Person.PersonBuilder();
        Person.PersonBuilder obj6 = new Person.PersonBuilder();

        obj4.setFirstName("Panda");
        obj4.setSecondName("D");
        obj4.setDateOfBirth(LocalDate.of(2002, 9, 5));
        obj4.setResidence(new Residence("Ukraine", "Chernivtsi", "Golovna 167"));

        obj5.setFirstName("Dima");
        obj5.setSecondName("B");
        obj5.setDateOfBirth(LocalDate.of(2003, 3, 2));
        obj5.setResidence(new Residence("Ukraine", "Kyiv", "Synogoge 322"));

        obj6.setFirstName("Matvey");
        obj6.setSecondName("A");
        obj6.setDateOfBirth(LocalDate.of(2007, 5, 23));
        obj6.setResidence(new Residence("Poland", "Chernivtsi", "Kyivska 12"));

        person2.add(obj4.build());
        person2.add(obj5.build());
        person2.add(obj6.build());
        Comparator surnameComparator = new PersonSurnameComparator();
        Collections.sort(person2, surnameComparator);
        for (Person p : person2) {
            System.out.println(p);
        }
        System.out.println("\n");

        List<Person> person3 = new ArrayList<>();
        Person.PersonBuilder obj7 = new Person.PersonBuilder();
        Person.PersonBuilder obj8 = new Person.PersonBuilder();
        Person.PersonBuilder obj9 = new Person.PersonBuilder();

        obj7.setFirstName("Serge");
        obj7.setSecondName("Proskurnyak");
        obj7.setDateOfBirth(LocalDate.of(2004, 9, 5));
        obj7.setResidence(new Residence("Ukraine", "Kyiv", "Golovna 167"));

        obj8.setFirstName("Vlad");
        obj8.setSecondName("Martin");
        obj8.setDateOfBirth(LocalDate.of(2003, 9, 25));
        obj8.setResidence(new Residence("Ukraine", "Chernivtsi", "Synogoge 322"));

        obj9.setFirstName("Sanya");
        obj9.setSecondName("Kolts");
        obj9.setDateOfBirth(LocalDate.of(2001, 7, 20));
        obj9.setResidence(new Residence("Poland", "Kyiv", "Kyivska 12"));

        person3.add(obj7.build());
        person3.add(obj8.build());
        person3.add(obj9.build());
        person3.stream().sorted(Comparator.comparingInt(Person::getDaysFromBirth)).forEach(System.out::println);

        System.out.println("\n");

        List<Person> person4 = new ArrayList<>();
        Person.PersonBuilder obj10 = new Person.PersonBuilder();
        Person.PersonBuilder obj11 = new Person.PersonBuilder();
        Person.PersonBuilder obj12 = new Person.PersonBuilder();

        obj10.setFirstName("a");
        obj10.setSecondName("z");
        obj10.setDateOfBirth(LocalDate.of(2004, 9, 5));
        obj10.setResidence(new Residence("Poland", "Chernivtsi", "Golovna 167"));

        obj11.setFirstName("a");
        obj11.setSecondName("b");
        obj11.setDateOfBirth(LocalDate.of(2004, 9, 5));
        obj11.setResidence(new Residence("Ukraine", "Kyiv", "Golovna 167"));

        obj12.setFirstName("a");
        obj12.setSecondName("c");
        obj12.setDateOfBirth(LocalDate.of(2004, 9, 5));
        obj12.setResidence(new Residence("Ukraine", "Chernivtsi", "Golovna 167"));

        person4.add(obj10.build());
        person4.add(obj11.build());
        person4.add(obj12.build());
        Comparator<Person> sortByAge = Comparator.comparing(Person::getDateOfBirth);
        Comparator<Person> sortByFirstName = Comparator.comparing(Person::getFirstName);
        Comparator<Person> sortByLastName = Comparator.comparing(Person::getSecondName);
        List<Comparator<Person>> comparators = new ArrayList<>();
        comparators.add(sortByAge);
        comparators.add(sortByFirstName);
        comparators.add(sortByLastName);
        person4.sort(new ChainComparator(comparators));
        for (Person p : person4) {
            System.out.println(p);
        }

        System.out.println("\ntest");
        List<Person> test = new ArrayList<>();
        test.addAll(person1);
        test.addAll(person2);
        test.addAll(person3);
        test.addAll(person4);
        PersonServiceWithStream ps = new PersonServiceWithStream(test);
        System.out.println("Full list");
        for (Person p : test) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByCity:");
        for (Person p : ps.getPersonsByCity("Chernivtsi")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByFirstName");
        for (Person p : ps.getPersonByFirstName("Serge")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsBySecondName");
        for (Person p : ps.getPersonBySecondName("Mazurka")) {
            System.out.println(p);
        }

        System.out.println("\ngetPersonsByCountry");
        for (Person p : ps.getPersonsByCountry("Poland")) {
            System.out.println(p);
        }
    }
}
