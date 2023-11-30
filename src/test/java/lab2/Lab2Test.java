package lab2;

import org.example.lab2.entities.Person;
import org.example.lab2.entities.Residence;
import org.example.lab2.serialize.Serialize;
import org.example.lab2.serialize.SerializeToJSON;
import org.example.lab2.serialize.SerializeToTxt;
import org.example.lab2.serialize.SerializeToXml;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class Lab2Test {

    @Test(dataProvider = "serializeTest")
    public void serializeProviderTest(String fileName, Serialize<Person> serializer, List<Person> objs) throws IOException, ClassNotFoundException {
        serializer.writeToFile(objs, fileName);
        List<Person> res = serializer.readFromFile(fileName);
        assertEquals(res, objs);
    }

    @DataProvider
    public Object[][] serializeTest() {
        List<Person> list = Arrays.asList(
                new Person("Oleh", "Alekseienko", LocalDate.of(2004, 9, 5), new Residence("Ukraine", "Chernivtsi", "Shevchenko 15")),
                new Person("Vika", "Alekseienko", LocalDate.of(2003, 11, 23), new Residence("Ukraine", "Kyiv", "Pushkina 123"))
        );
        return new Object[][]{
                {"test123.json", new SerializeToJSON(), list},
                {"test1234.xml", new SerializeToXml(), list},
                {"test1235.txt", new SerializeToTxt(), list}
        };
    }
}
