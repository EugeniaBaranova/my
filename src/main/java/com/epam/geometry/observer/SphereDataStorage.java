package com.epam.geometry.observer;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.SphereObservable;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class SphereDataStorage {

    private double volume;
    private double surfaceArea;

    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(
                    CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public double getVolume() {
        return volume;
    }

    public void setVolume(SphereObservable sphereObservable) {
        volume = sphereCalculator.calculateVolume(sphereObservable);
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(SphereObservable sphereObservable) {
        surfaceArea = sphereCalculator.calculateSurfaceArea(sphereObservable);
    }
}
