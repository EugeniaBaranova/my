package com.epam.geometry.model.service.reader;

import com.epam.geometry.model.service.reader.exception.MissingDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DataReader {

    private StringValidator stringValidator = new StringValidator();

    List<String> getValidLines(String fileName) throws MissingDataException {

        List<String> lines = readLines(fileName);
        return lines.stream()
                .filter(line -> stringValidator.validateString(line))
                .collect(Collectors.toList());


    }

    private List<String> readLines(String fileName) throws MissingDataException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            //TODO Logger
            throw new MissingDataException(e);
        }
        return lines;
    }


    private void addValidLinesToList(String line, int numberOfLine, List<String> lines) {
        if (stringValidator.validateString(line)) {
            lines.add(line);
        } else {
            System.out.println("Line " + numberOfLine + " is invalid.");
            //TODO logger
        }
    }


}
