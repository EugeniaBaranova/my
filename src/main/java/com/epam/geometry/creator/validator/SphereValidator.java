package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;

public class SphereValidator implements ShapeValidator {

    @Override
    public SphereValidationResult validate(PossibleShapeDataKeeper sphereDataKeeper) {
        SphereValidationResult sphereValidationResult = new SphereValidationResult();
        if (sphereDataKeeper != null) {
            PossibleSphereDataKeeper possibleSphereDataKeeper = (PossibleSphereDataKeeper) sphereDataKeeper;
            if (possibleSphereDataKeeper.getPossibleRadius() > 0) {
                sphereValidationResult.setResult(possibleSphereDataKeeper);
            } else {
                sphereValidationResult.setError("Invalid radius " + possibleSphereDataKeeper.getPossibleRadius());
            }
        }
        return sphereValidationResult;
    }
}
