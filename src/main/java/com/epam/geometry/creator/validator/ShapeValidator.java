package com.epam.geometry.creator.validator;

public interface ShapeValidator<T> {

    SphereValidationResult validate(T possibleShapeDataKeeper);

}