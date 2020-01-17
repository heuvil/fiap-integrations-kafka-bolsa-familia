package br.com.fiap.mba.csvToKafka.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;


public class CSVDataLoader {

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
            CsvMapper mapper = new CsvMapper();
            //File file = new ClassPathResource(fileName).getFile();
            InputStream resource = new ClassPathResource(fileName).getInputStream();
            MappingIterator<T> readValues =
                    mapper.readerFor(type).with(bootstrapSchema).readValues(resource);
            return readValues.readAll();

        } catch (Exception e) {
            System.out.println("Error occurred while loading object list from file " + fileName);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
