package lab3;

import org.example.lab3.ChainComparator;
import org.example.lab3.Person;
import org.example.lab3.PersonSurnameComparator;
import org.example.lab3.Residence;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
public class Lab3Test {
    Person obj1 = new Person("Oleg","Demon",18, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj2 = new Person("Serge","Mazurka",25, new Residence("Ukraine","Chernivtsi","Synogoge 322"));
    Person obj3 = new Person("Bogdan","Mazurka",21, new Residence("Ukraine","Chernivtsi","Kyivska 12"));
    Person obj4 = new Person("Panda","D",26, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj5 = new Person("Dima","B",19, new Residence("Ukraine","Chernivtsi","Synogoge 322"));
    Person obj6 = new Person("Matvey","A",20, new Residence("Ukraine","Chernivtsi","Kyivska 12"));
    Person obj7 = new Person("Max","Proskurnyak",26, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj8 = new Person("Vlad","Martin",19, new Residence("Ukraine","Chernivtsi","Synogoge 322"));
    Person obj9 = new Person("Sanya","Kolts",20, new Residence("Ukraine","Chernivtsi","Kyivska 12"));
    Person obj10 = new Person("a" , "z", 11, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj11 = new Person("a" , "b", 11, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj12 = new Person("a" , "c", 11, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj13 = new Person("Santa","Klaus",15, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj14 = new Person("Oleg","Oleksik",18, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    Person obj15 = new Person("Serg","Pezduk",19, new Residence("Ukraine","Chernivtsi","Golovna 167"));
    @Test(dataProvider = "sortBySurname")
    public void sortBySurnameProvider(List<Person>list, List<Person>res)
    {
        Comparator<Person> surnameComparator = new PersonSurnameComparator();
        Collections.sort(list,surnameComparator);
        assertEquals(list,res);
    }
    @DataProvider
    public Object[][] sortBySurname()
    {
        List<Person>list1 = new ArrayList<>();
        List<Person>res1 = new ArrayList<>();
        List<Person>list2 = new ArrayList<>();
        List<Person>res2 = new ArrayList<>();
        list1.add(obj4);
        list1.add(obj5);
        list1.add(obj6);
        list2.add(obj2);
        list2.add(obj3);
        list2.add(obj1);
        res1.add(obj6);
        res1.add(obj5);
        res1.add(obj4);
        res2.add(obj1);
        res2.add(obj2);
        res2.add(obj3);
        return new Object[][]{{list1,res1},{list2,res2}};
    }
    @Test(dataProvider = "sortByAge")
    public void sortByAgeProvider(List<Person>list, List<Person>res)
    {
        list = list.stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());
        assertEquals(list,res);
    }
    @DataProvider
    public Object[][] sortByAge()
    {
        List<Person>list1 = new ArrayList<>();
        List<Person>res1 = new ArrayList<>();
        List<Person>list2 = new ArrayList<>();
        List<Person>res2 = new ArrayList<>();
        list1.add(obj7);
        list1.add(obj8);
        list1.add(obj9);
        res1.add(obj8);
        res1.add(obj9);
        res1.add(obj7);
        list2.add(obj1);
        list2.add(obj2);
        list2.add(obj3);
        res2.add(obj1);
        res2.add(obj3);
        res2.add(obj2);
        return new Object[][]{{list1,res1}, {list2,res2}};
    }

    @Test
    public void sortByChainComparatorProvider()
    {
        List<Person>list1 = new ArrayList<>();
        List<Person>res1 = new ArrayList<>();
        list1.add(obj10);
        list1.add(obj11);
        list1.add(obj12);
        res1.add(obj11);
        res1.add(obj12);
        res1.add(obj10);
        List<Comparator<Person>> comparators = new ArrayList<>();
        comparators.add(Comparator.comparing(Person::getAge));
        comparators.add(Comparator.comparing(Person::getFirstName));
        comparators.add(Comparator.comparing(Person::getSecondName));
        list1.sort(new ChainComparator(comparators));
        assertEquals(list1,res1);
    }
}