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
        logger.debug("Start to execute method.");

        List<String> lines = new ArrayList<>();
        Optional<String> filePath = getFilePath(fileName);
        if(filePath.isPresent()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.get()))) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                logger.error("Can't read file.", e);
                throw new MissingDataException(e);
            }
        }
        logger.debug("Stop to execute method.");
        return lines;
    }


    private Optional<String> getFilePath(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader != null){
            URL resource = classLoader.getResource(fileName);
            if(resource != null){
                String path = resource.getPath();
                return Optional.of(path);
            }
        }
        return Optional.empty();
    }

}
