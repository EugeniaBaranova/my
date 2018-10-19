package com.epam.geometry.model.service.validator;

import com.epam.geometry.model.entity.Sphere;

public class SphereValidatorImpl implements SphereValidator {

    public boolean validate(Sphere sphere) {
        return sphere.getRadius() > 0;
    }
}
