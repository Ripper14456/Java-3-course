package org.example.lab2.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.example.lab2.entities.*;

import java.io.*;
import java.util.List;

public class SerializeToTxt implements Serialize<Object> {
    @Override
    public void writeToFile(List<Object> objs, String fileName) throws IOException
    {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        CsvSchema schema = mapper.schemaFor(Person.class);
        ObjectWriter writer = mapper.writerFor(Person.class).with(schema);
        writer.writeValues(new File(fileName)).writeAll(objs);
    }

    @Override
    public List<Object> readFromFile(String fileName) throws IOException
    {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
        CsvSchema schema = mapper.schemaFor(Person.class);
        ObjectReader reader = mapper.readerFor(Person.class).with(schema);
        return (List)reader.readValues(new File(fileName)).readAll();
    }
}
