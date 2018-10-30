package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class SurfaceAreaInRangeSpecification implements Specification<Sphere>{

    private double minVolume;
    private double maxVolume;
    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public SurfaceAreaInRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Sphere object) {
        double currentVolume = sphereCalculator.calculateSurfaceArea(object);
        return Double.compare(currentVolume, minVolume) >= 0 && Double.compare(currentVolume, maxVolume) <= 0;
    }
}
