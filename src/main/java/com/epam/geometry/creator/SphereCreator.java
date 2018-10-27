package com.epam.geometry.creator;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.creator.validator.SphereValidationResult;
import com.epam.geometry.creator.validator.ShapeValidator;
import com.epam.geometry.generator.IDGenerator;
import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator implements ShapeCreator {

    private ShapeValidator validator;

    public SphereCreator(ShapeValidator validator) {
        this.validator = validator;
    }


    @Override
    public List<? extends Shape> create(List<? extends PossibleShapeDataKeeper> parametersForSpheres) {
        List<Sphere> spheres = new ArrayList<>();
        if (parametersForSpheres != null) {
            for (PossibleShapeDataKeeper sphereDataKeeper: parametersForSpheres) {
                SphereValidationResult validateResult = validator.validate((PossibleSphereDataKeeper)sphereDataKeeper);
                if (validateResult.getError() == null) {
                    PossibleSphereDataKeeper sphereParameters = validateResult.getResult();
                    Sphere sphere = new Sphere();
                    sphere.setCenter(new Point(
                            sphereParameters.getPossibleXofCenter(),
                            sphereParameters.getPossibleYofCenter(),
                            sphereParameters.getPossibleZofCenter()));
                    sphere.setRadius(sphereParameters.getPossibleRadius());
                    sphere.setId(IDGenerator.getInstance()
                            .getCount());
                    spheres.add(sphere);
                }
            }
        }
        return spheres;

    }
}
