package org.example.lab2.serialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.lab2.entities.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToJSON implements Serialize<Person> {
    @Override
    public void writeToFile(List<Person> objs, String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.writeValue(new File(fileName),objs);
    }

    @Override
    public List<Person> readFromFile(String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> res = mapper.readValue(new File(fileName), new TypeReference<List<Person>>(){});
        return res;
    }
}
