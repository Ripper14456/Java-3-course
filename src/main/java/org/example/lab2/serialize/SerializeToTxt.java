package org.example.lab2.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.example.lab2.entities.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class SerializeToTxt implements Serialize<Person> {

    private final ObjectMapper mapper;

    public SerializeToTxt() {
        mapper = new ObjectMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        mapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new ToStringSerializer());
        module.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE);
        mapper.registerModule(module);
    }

    @Override
    public void writeToFile(List<Person> persons, String fileName) throws IOException {
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(persons);
        List<String> lines = Arrays.asList(jsonString.split("\n"));

        Files.write(Paths.get(fileName), lines);
    }

    @Override
    public List<Person> readFromFile(String fileName) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(fileName)));
        Person[] personsArray = mapper.readValue(content, Person[].class);
        return Arrays.asList(personsArray);
    }
}
