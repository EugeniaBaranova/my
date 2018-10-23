package com.epam.geometry.reader;


import java.util.ArrayList;
import java.util.List;

public class SphereStringValidator implements StringValidator {

    private static final String FIXED_FORMAT_OF_STRING =
            "x=-?\\d+(\\.\\d+)?;\\sy=-?\\d+(\\.\\d+)?;\\sz=-?\\d+(\\.\\d+)?;\\sr=\\d+(\\.\\d+)?";

    @Override
    public List<String> getValidLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        if (lines != null) {
            for (String line : lines) {
                if (line != null) {
                    if (line.matches(FIXED_FORMAT_OF_STRING)) {
                        validLines.add(line);
                    }
                }
            }
        }
        return validLines;
    }

}
