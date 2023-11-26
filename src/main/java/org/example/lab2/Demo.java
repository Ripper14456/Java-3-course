package org.example.lab2;

import org.example.lab2.entities.*;
import org.example.lab2.serialize.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        Person.PersonBuilder oleh = new Person.PersonBuilder();
        Person.PersonBuilder vika = new Person.PersonBuilder();

        oleh.setFirstName("Oleh");
        oleh.setSecondName("Alekseienko");
        oleh.setDateOfBirth(LocalDate.of(2004,12,23));
        oleh.setResidence(new Residence("Ukraine","Chernivtsi","Shevchenka 15"));

        vika.setFirstName("Vika");
        vika.setSecondName("Alekseienko");
        vika.setDateOfBirth(LocalDate.of(2004,12,23));
        vika.setResidence(new Residence("Ukraine","Kyiv","Pushkina 123"));


        List<Person> myList = new ArrayList<>();
        myList.add(oleh.build());
        myList.add(vika.build());

        SerializeToJSON serializerJSON = new SerializeToJSON();
        SerializeToXml serializerToXml = new SerializeToXml();
        SerializeToTxt serializerToTxt = new SerializeToTxt();


        System.out.println("JSON:");
        serializerJSON.writeToFile(myList,"test123.json");
        System.out.println(serializerJSON.readFromFile("test123.json"));

        System.out.println("XML:");
        serializerToXml.writeToFile(myList,"test1234.xml");
        System.out.println(serializerToXml.readFromFile("test1234.xml"));

        System.out.println("TXT:");
        serializerToTxt.writeToFile(myList,"test1235.txt");
        System.out.println(serializerToTxt.readFromFile("test1235.txt"));
    }
}