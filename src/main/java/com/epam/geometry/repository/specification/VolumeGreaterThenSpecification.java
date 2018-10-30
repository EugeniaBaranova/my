package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class VolumeGreaterThenSpecification implements Specification<Sphere> {

    private double volume;
    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public VolumeGreaterThenSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Sphere object) {
        double currentVolume = sphereCalculator.calculateVolume(object);
        return Double.compare(currentVolume, volume) > 0;
    }
}
