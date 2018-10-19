package com.epam.geometry.model.service.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataReader {

    private StringValidator stringValidator = new StringValidator();

    public List<String> read(String fileName) throws MissingDataException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            Map<String, Integer> numbersOfLines = new HashMap<>();
            int numberOfLine = 1;
            numbersOfLines.put(line, numberOfLine);

            while (line != null) {
                addValidLinesToList(line, numbersOfLines.get(line), lines);
                line = bufferedReader.readLine();
                numberOfLine++;
                numbersOfLines.put(line, numberOfLine);
            }
        } catch (IOException e) {
            //TODO Logger
            throw new MissingDataException(e);
        }
        return lines;
    }

    private List<String> addValidLinesToList(String line, int numberOfLine, List<String> lines) {
        if (stringValidator.validateString(line)) {
            lines.add(line);
        } else {
            System.out.println("Line " + numberOfLine + " is invalid.");
            //TODO logger
        }
        return lines;
    }

}
