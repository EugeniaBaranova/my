package com.epam.geometry.observer;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.SphereObservable;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class SphereDataStorage {

    private double volume;
    private double surfaceArea;

    private SphereObservable sphereObservable;

    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(
                    CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public SphereDataStorage(SphereObservable sphereObservable) {
        this.sphereObservable = sphereObservable;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(SphereObservable sphereObservable) {
        this.volume = sphereCalculator.calculateVolume(this.sphereObservable);
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(SphereObservable sphereObservable) {
        this.surfaceArea = sphereCalculator.calculateSurfaceArea(this.sphereObservable);
    }
}
