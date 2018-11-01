package com.epam.geometry.creator;

import com.epam.geometry.creator.validator.SphereValidator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.creator.validator.SphereValidationResult;
import com.epam.geometry.generator.IdGenerator;
import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.impl.PossibleSphereDataKeeper;

import java.util.ArrayList;
import java.util.List;

public class SphereCreator implements ShapeCreator {

    private SphereValidator validator;

    public SphereCreator(SphereValidator validator) {
        this.validator = validator;
    }


    @Override
    public List<? extends Shape> create(List<? extends PossibleShapeDataKeeper> parametersForSpheres) {
        List<Sphere> spheres = new ArrayList<>();
        if (parametersForSpheres != null) {

            for (PossibleShapeDataKeeper sphereDataKeeper : parametersForSpheres) {
                SphereValidationResult validateResult = validator.validate((PossibleSphereDataKeeper)sphereDataKeeper);
                if (validateResult.getError() == null) {

                    PossibleSphereDataKeeper sphereParameters = validateResult.getResult();
                    Sphere sphere = new Sphere();

                    double possibleXofCenter = sphereParameters.getPossibleXofCenter();
                    double possibleYofCenter = sphereParameters.getPossibleYofCenter();
                    double possibleZofCenter = sphereParameters.getPossibleZofCenter();
                    double possibleRadius = sphereParameters.getPossibleRadius();

                    IdGenerator idGenerator = IdGenerator.getInstance();
                    long id = idGenerator.getCount();

                    sphere.setCenter(new Point(
                            possibleXofCenter,
                            possibleYofCenter,
                            possibleZofCenter));
                    sphere.setRadius(possibleRadius);
                    sphere.setId(id);
                    spheres.add(sphere);
                }
            }
        }
        return spheres;
    }
}
