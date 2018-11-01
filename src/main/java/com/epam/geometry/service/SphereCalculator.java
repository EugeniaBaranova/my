package com.epam.geometry.service;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.commandsForSphereCenter.Command;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;
import com.epam.geometry.service.exception.ServiceException;

import java.util.List;


public class SphereCalculator {

    private CommandProvider commandProvider;
    private List<CoordinatePlane> coordinatePlanes;

    public SphereCalculator(CommandProvider commandProvider, List<CoordinatePlane> coordinatePlanes) {
        this.commandProvider = commandProvider;
        this.coordinatePlanes = coordinatePlanes;
    }

    public double calculateSurfaceArea(Sphere sphere) {
        return calculateWithFormula(sphere, 2, 4);
    }

    public double calculateVolume(Sphere sphere) {
        return calculateWithFormula(sphere, 3, (4d / 3d));
    }

    private double calculateWithFormula(Sphere sphere, double x, double y) {
        double result = 0;
        if (sphere != null) {
            double radius = sphere.getRadius();
            if (radius > 0) {
                return (Math.pow(radius, x))
                        * (Math.PI * y);
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
                            double centerCoordinate = command.execute(sphere);
                            double heightOfSphericalCap = sphereRadius - Math.abs(centerCoordinate);
                            double volumeOfSphericalCap = Math.PI *
                                    (Math.pow(heightOfSphericalCap, 2) / 3) *
                                    (3 * sphereRadius - heightOfSphericalCap);
                            double volumeOfRemainingSphericalSegment =
                                    calculateVolume(sphere) - volumeOfSphericalCap;
                            return volumeOfRemainingSphericalSegment / volumeOfSphericalCap;
                        }
                    }
                }
            }
        }
        return result;
    }

    public boolean doesContactWithPlane(Sphere sphere, CoordinatePlane coordinatePlane) {
        Double result = getDeltaCoordinates(sphere, coordinatePlane);
        return result != null && result == 0;
    }


    private boolean doesCrossCoordinatePlane(Sphere sphere, CoordinatePlane coordinatePlane) {
        Double result = getDeltaCoordinates(sphere, coordinatePlane);
        return result != null && result < 0;
    }


    private Double getDeltaCoordinates(Sphere sphere, CoordinatePlane coordinatePlane) {

        if (sphere != null && coordinatePlane != null) {
            for (CoordinatePlane plane : this.coordinatePlanes) {
                if (coordinatePlane.equals(plane)) {
                    Command command = commandProvider.getCommand(coordinatePlane);
                    if (command != null) {
                        double centerCoordinate = command.execute(sphere);
                        double radius = sphere.getRadius();
                        return (Math.abs(centerCoordinate) - radius);
                    }
                }
            }
        }
        return null;
    }

}
