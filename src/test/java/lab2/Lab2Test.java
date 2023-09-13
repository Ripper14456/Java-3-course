package lab2;

import static org.testng.Assert.assertEquals;

import org.example.lab2.serialize.*;
import org.example.lab2.entities.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Lab2Test {

    @Test(dataProvider = "serializeToJSONTest")
    public void serializeProviderTest(String fileName, Serialize<Person> serializer, List<Person> objs) throws IOException, ClassNotFoundException {
        serializer.writeToFile(objs, fileName);
        List<Person> res = serializer.readFromFile(fileName);
        assertEquals(res, objs);
    }

    @DataProvider
    public Object[][] serializeToJSONTest() {
        List<Person> list = Arrays.asList
                (
                        new Person("Serg", "Mazurok", 19, new Residence("Ukraine", "Chernivtsi", "Golovna 165")),
                        new Person("Bogdan", "Mazurok", 16, new Residence("Ukraine", "Kyiv", "Pushkina 123"))
                );
        return new Object[][]
                {
                        {"test123.json", new SerializeToJSON(), list},
                        {"test1234.xml", new SerializeToXml(), list},
                        {"test1235.txt", new SerializeToTxt(), list}
                };
    }
}
