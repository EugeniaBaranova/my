package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.impl.PossibleSphereDataKeeper;

public class SphereValidator {

    public SphereValidationResult validate(PossibleSphereDataKeeper possibleSphereDataKeeper) {
        SphereValidationResult sphereValidationResult = new SphereValidationResult();
        if (possibleSphereDataKeeper != null) {

            double possibleRadius = possibleSphereDataKeeper.getPossibleRadius();
            if (possibleRadius > 0) {
                sphereValidationResult.setResult(possibleSphereDataKeeper);
            } else {
                sphereValidationResult.setError("Invalid radius " + possibleRadius);
            }
        }
        return sphereValidationResult;
    }
}
