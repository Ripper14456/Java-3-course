package org.example.lab2;

import org.example.lab2.entities.*;
import org.example.lab2.serialize.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person oleh = new Person("Oleh","Alekseienko",19,new Residence("Ukraine","Chernivtsi","Shevchenka 15"));
        Person vika = new Person("Vika","Alekseienko",16,new Residence("Ukraine","Kyiv","Pushkina 123"));

        List<Person> myList = new ArrayList<>();
        myList.add(oleh);
        myList.add(vika);

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
        serializerToTxt.writeToFile(Collections.singletonList(myList),"test1235.txt");
        System.out.println(serializerToTxt.readFromFile("test1235.txt"));
    }
}