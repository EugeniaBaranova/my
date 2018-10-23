package com.epam.geometry.stringParser;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SphereStringParser implements ShapeStringParser {

    private static final String SEMICOLON = ";\\s";
    private static final String EQUAL_SIGN = "=";

    @Override
    public List<PossibleSphereDataKeeper> parseLines(List<String> validLines) {
        List<PossibleSphereDataKeeper> parametersForSpheres = new ArrayList<>();
        if (validLines != null) {
            for (String validLine : validLines) {
                if (validLine != null) {
                    Queue<Double> possibleParameters = new ArrayDeque<>();
                    String[] pairsParameterAndValue = validLine.split(SEMICOLON);
                    for (String pairParameterAndValue : pairsParameterAndValue) {
                        String[] parameterAndValue = pairParameterAndValue.split(EQUAL_SIGN);
                        possibleParameters.offer(Double
                                .valueOf(parameterAndValue[1]));
                    }
                    parametersForSpheres.add(new PossibleSphereDataKeeper(possibleParameters));
                }
            }
        }
        return parametersForSpheres;
    }
}
