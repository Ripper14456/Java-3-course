package org.example.lab2;

import org.example.lab2.entities.*;
import org.example.lab2.serialize.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person serg = new Person("Serg","Mazurok",19,new Residence("Ukraine","Chernivtsi","Golovna 165"));
        Person bogdan = new Person("Bogdan","Mazurok",16,new Residence("Ukraine","Kyiv","Pushkina 123"));

        List<Person> myList = new ArrayList<>();
        myList.add(serg);
        myList.add(bogdan);

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