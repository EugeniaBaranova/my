package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.PossibleShapeDataKeeper;

public interface ShapeValidator {

    SphereValidationResult validate(PossibleShapeDataKeeper parametersForOneSphere);

}