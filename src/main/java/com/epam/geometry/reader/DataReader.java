package com.epam.geometry.reader;

import com.epam.geometry.reader.exception.MissingDataException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataReader {

    private static final Logger logger = Logger.getLogger(DataReader.class);

    public List<String> readLines(String fileName) throws MissingDataException {
        logger.info("Read file.");

        List<String> lines = new ArrayList<>();
        Optional<String> filePath = getFilePath(fileName);
        if(filePath.isPresent()){
            String line;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.get()))) {
                while (((line = bufferedReader.readLine()) != null)) {
                    lines.add(line);
                }
            } catch (IOException e) {
                logger.error("Can't read file.", e);
                throw new MissingDataException(e);
            }
        }
        return lines;
    }


    private Optional<String> getFilePath(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if(resource != null){
            return Optional.of(resource.getPath());
        }
        return Optional.empty();
    }

}
