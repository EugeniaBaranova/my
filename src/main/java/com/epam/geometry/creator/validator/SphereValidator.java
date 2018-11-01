package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;

public class SphereValidator implements ShapeValidator<PossibleSphereDataKeeper> {

    @Override
    public SphereValidationResult validate(PossibleSphereDataKeeper possibleSphereDataKeeper) {
        SphereValidationResult sphereValidationResult = new SphereValidationResult();
        if (possibleSphereDataKeeper != null) {
            if (possibleSphereDataKeeper.getPossibleRadius() > 0) {
                sphereValidationResult.setResult(possibleSphereDataKeeper);
            } else {
                sphereValidationResult.setError("Invalid radius " + possibleSphereDataKeeper.getPossibleRadius());
            }
        }
        return sphereValidationResult;
    }
}
