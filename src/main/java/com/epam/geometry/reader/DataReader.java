package com.epam.geometry.reader;

import com.epam.geometry.reader.exception.MissingDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataReader {

    public List<String> readLines(String fileName) throws MissingDataException {

        List<String> lines = new ArrayList<>();
        Optional<String> filePath = getFilePath(fileName);
        if(filePath.isPresent()){
            String line;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.get()))) {
                while (((line = bufferedReader.readLine()) != null)) {
                    lines.add(line);
                }
            } catch (IOException e) {
                //TODO Logger
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
