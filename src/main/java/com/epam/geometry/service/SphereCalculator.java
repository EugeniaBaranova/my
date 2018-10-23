package com.epam.geometry.service;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.commandsForVolumeRatio.Command;
import com.epam.geometry.service.commandsForVolumeRatio.CommandProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class SphereCalculator {

    private CommandProvider commandProvider;
    private List<CoordinatePlane> coordinatePlanes;

    public SphereCalculator(CommandProvider commandProvider, List<CoordinatePlane> coordinatePlanes) {
        this.commandProvider = commandProvider;
        this.coordinatePlanes = coordinatePlanes;
    }

    public double calculateSurfaceArea(Sphere sphere) {
        return calculate(sphere, 2, 4);
    }

    public double calculateVolume(Sphere sphere) {
        return calculate(sphere, 3, 4 / 3);
    }

    private double calculate(Sphere sphere, double x, double y) {
        double result = 0;
        if (sphere != null) {
            if (sphere.getRadius() > 0) {
                return Math.pow(sphere
                        .getRadius(), x) *
                        Math.PI * y;
            } else {
                throw new ServiceException();
            }
        }
        return result;
    }


    public double calculateVolumeRatio(Sphere sphere, CoordinatePlane coordinatePlane) {
        double result = 0;
        if (sphere != null && coordinatePlane != null) {
            for (CoordinatePlane plane : this.coordinatePlanes) {
                if (coordinatePlane.equals(plane)) {
                    if (doesCrossCoordinatePlane(sphere, coordinatePlane)) {
                        Double sphereRadius = sphere.getRadius();
                        Command command = commandProvider.getCommand(coordinatePlane);
                        if (command != null) {
                            double heightOfSphericalCap = sphereRadius - Math.abs(command
                                    .execute(sphere));
                            double volumeOfSphericalCap = Math.PI *
                                    (Math.pow(heightOfSphericalCap, 2) / 3) *
                                    (3 * sphere.getRadius() - heightOfSphericalCap);
                            double volumeOfRemainingSphericalSegment = calculateVolume(sphere) - volumeOfSphericalCap;
                            return volumeOfRemainingSphericalSegment / volumeOfSphericalCap;
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean doesContactWithPlane(Sphere sphere, CoordinatePlane coordinatePlane) {
        Double result = doesContain(sphere, coordinatePlane);
        return result != null && result == 0;

    }


    private boolean doesCrossCoordinatePlane(Sphere sphere, CoordinatePlane coordinatePlane) {
        Double result = doesContain(sphere, coordinatePlane);
        return result != null && result < 0;

    }


    private Double doesContain(Sphere sphere, CoordinatePlane coordinatePlane) {

        if (sphere != null && coordinatePlane != null) {
            for (CoordinatePlane plane : this.coordinatePlanes) {
                if (coordinatePlane.equals(plane)) {
                    Command command = commandProvider.getCommand(coordinatePlane);
                    if (command != null) {
                        return (Math.abs(command.execute(sphere)) - sphere.getRadius());
                    }
                }
            }
        }
        return null;
    }

}
