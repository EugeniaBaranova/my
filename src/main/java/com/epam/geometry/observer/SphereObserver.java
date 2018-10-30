package com.epam.geometry.observer;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.entity.SphereObservable;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class SphereObserver implements Observer {

    private SphereObservable sphereObservable;
    private double volume;
    private double surfaceArea;

    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public SphereObserver(SphereObservable sphereObservable) {
        this.sphereObservable = sphereObservable;
        this.sphereObservable.attach(this);
    }

    public double getVolume() {
        return volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public void update() {
        this.volume = sphereCalculator.calculateVolume(this.sphereObservable);
        this.surfaceArea = sphereCalculator.calculateSurfaceArea(this.sphereObservable);
    }
}
