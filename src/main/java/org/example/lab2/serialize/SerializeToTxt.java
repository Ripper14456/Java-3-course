package org.example.lab2.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.example.lab2.entities.Person;
import java.time.LocalDate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToTxt implements Serialize<Person> {
    @Override
    public void writeToFile(List<Person> persons, String fileName) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        mapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new ToStringSerializer());
        mapper.registerModule(module);

        CsvSchema schema = mapper.schemaFor(Person.class);
        ObjectWriter writer = mapper.writerFor(Person.class).with(schema);
        writer.writeValues(new File(fileName)).writeAll(persons);
    }

    @Override
    public List<Person> readFromFile(String fileName) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        mapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE);
        mapper.registerModule(module);

        CsvSchema schema = mapper.schemaFor(Person.class);
        MappingIterator<Person> iterator = mapper.readerFor(Person.class)
                .with(schema)
                .readValues(new File(fileName));
        return iterator.readAll();
    }
}