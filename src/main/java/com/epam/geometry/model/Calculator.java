package com.epam.geometry.model;

import com.epam.geometry.model.entity.Sphere;

public class Calculator {

    public double calculateSurfaceArea(Sphere sphere) {
        return Math.pow(sphere
                .getRadius(), 2) *
                Math.PI * 4;
    }

    public double calculateVolume(Sphere sphere) {
        return Math.pow(sphere
                .getRadius(), 3) *
                Math.PI * 4 / 3;
    }

    public double calculateVolumeRatioAfterCrossSection(Sphere sphere, CoordinatePlane coordinatePlane) {
        double heightOfSphericalCap = 0.0;
        if (coordinatePlane.getIntersectionPointWithCoordinateAxes().getZ() == 0 &&
                coordinatePlane.getIntersectionPointWithCoordinateAxes().getY() == 0) {
            heightOfSphericalCap = sphere.getRadius() -
                    Math.abs(
                            sphere.getCenter()
                                    .getX() -
                                    coordinatePlane.getIntersectionPointWithCoordinateAxes()
                                            .getX());
        }
        double volumeOfSphericalCap = Math.PI *
                Math.pow(heightOfSphericalCap, 2) / 3 *
                (3 * sphere.getRadius() - heightOfSphericalCap);
        double volumeOfRemainingSphericalSegment = calculateVolume(sphere) - volumeOfSphericalCap;
        return volumeOfRemainingSphericalSegment/volumeOfSphericalCap;
    }
}
