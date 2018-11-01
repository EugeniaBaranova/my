package com.epam.geometry.observer;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.entity.SphereObservable;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class SphereObserver implements Observer {

    private SphereObservable sphereObservable;

    public SphereObserver(SphereObservable sphereObservable) {
        this.sphereObservable = sphereObservable;
        this.sphereObservable
                .attach(this);
    }

    @Override
    public void update() {
        SphereDataStorage sphereDataStorage = sphereObservable
                .getSphereDataStorage();
        sphereDataStorage.setVolume(sphereObservable);
        sphereDataStorage.setSurfaceArea(sphereObservable);
    }
}
