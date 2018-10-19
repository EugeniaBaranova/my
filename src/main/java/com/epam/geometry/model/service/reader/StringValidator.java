package com.epam.geometry.model.service.reader;


import java.util.HashMap;
import java.util.Map;

public class StringValidator {

    private static final String FIXED_FORMAT_OF_STRING =
            "x=-?\\d+(\\.\\d+)?;\\sy=-?\\d+(\\.\\d+)?;\\sz=-?\\d+(\\.\\d+)?;\\sr=\\d+(\\.\\d+)?";
    private static final String NEGATIVE_RADIUS =
            "x=-?\\d+(\\.\\d+)?;\\sy=-?\\d+(\\.\\d+)?;\\sz=-?\\d+(\\.\\d+)?;\\sr=-?\\d+(\\.\\d+)?";
    private static final String ZERO_RADIUS =
            "x=-?\\d+(\\.\\d+)?;\\sy=-?\\d+(\\.\\d+)?;\\sz=-?\\d+(\\.\\d+)?;\\sr=0";
    private static final String WITHOUT_SPACES_AFTER_SEMICOLONS =
            "x=-?\\d+(\\.\\d+)?;y=-?\\d+(\\.\\d+)?;z=-?\\d+(\\.\\d+)?;r=-?\\d+(\\.\\d+)?";
    private static final String TOO_MANY_SPACES_AFTER_SEMICOLONS =
            "x=-?\\d+(\\.\\d+)?;\\s\\s+y=-?\\d+(\\.\\d+)?;\\s\\s+z=-?\\d+(\\.\\d+)?;\\s\\s+r=-?\\d+(\\.\\d+)?";
    private static final String EMPTY_STRING = "\\s*";
    private static final String INCORRECT_FORMAT = "Incorrect format of string. ";
    private static Map<String, String> incorrectFormatsToChooseMessage = new HashMap<>();

    static {
        incorrectFormatsToChooseMessage.put(NEGATIVE_RADIUS, INCORRECT_FORMAT + "Radius is negative.");
        incorrectFormatsToChooseMessage.put(WITHOUT_SPACES_AFTER_SEMICOLONS,
                INCORRECT_FORMAT + "Spaces after semicolons are absent.");
        incorrectFormatsToChooseMessage.put(TOO_MANY_SPACES_AFTER_SEMICOLONS,
                INCORRECT_FORMAT + "Too many spaces after semicolons.");
        incorrectFormatsToChooseMessage.put(EMPTY_STRING, INCORRECT_FORMAT + "String is empty.");
    }

    public boolean validateString(String string) {
        if (string != null) {
            if(string.matches(ZERO_RADIUS)){
                System.out.println(INCORRECT_FORMAT + "Radius is zero.");
                //TODO logger;
                return false;
            }
            if (string.matches(FIXED_FORMAT_OF_STRING)) {
                return true;
            }
            for (String incorrectFormat : incorrectFormatsToChooseMessage.keySet()) {
                if (string.matches(incorrectFormat)) {
                    System.out.println(incorrectFormatsToChooseMessage.get(incorrectFormat));
                    //TODO logger;
                    return false;
                }
            }
            System.out.println(INCORRECT_FORMAT);
        }
        return false;
    }

}
