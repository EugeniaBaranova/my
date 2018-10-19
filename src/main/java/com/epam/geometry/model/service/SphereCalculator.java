package com.epam.geometry.model.service;

import com.epam.geometry.model.entity.Point;
import com.epam.geometry.model.entity.Sphere;
import com.epam.geometry.model.service.validator.SphereValidator;

import java.util.*;

public class SphereCalculator {

    private SphereValidator validator;

    public SphereCalculator(SphereValidator validator) {
        this.validator = validator;
    }

    public double calculateSurfaceArea(Sphere sphere) {
        if (validator.validate(sphere)) {
            return Math.pow(sphere
                    .getRadius(), 2) *
                    Math.PI * 4;
        }
        throw new ServiceException();
    }

    public double calculateVolume(Sphere sphere) {
        if (validator.validate(sphere)) {
            return Math.pow(sphere
                    .getRadius(), 3) *
                    Math.PI * 4 / 3;
        }
        throw new ServiceException();
    }

    public double calculateVolumeRatioAfterCrossSection(Sphere sphere, CoordinatePlane coordinatePlane) {
        double heightOfSphericalCap = 0.0;
        Point sphereCenter = sphere.getCenter();
        Point intersectionPointOfCoordinatePlane = coordinatePlane.getIntersectionWithAxis();

        List<Double> xOfCenterAndIntersectionPoint = new ArrayList<>(Arrays.asList(
                sphereCenter.getX(),
                intersectionPointOfCoordinatePlane.getX()));
        List<Double> yOfCenterAndIntersectionPoint = new ArrayList<>(Arrays.asList(
                sphereCenter.getY(),
                intersectionPointOfCoordinatePlane.getY()));
        List<Double> zOfCenterAndIntersectionPoint = new ArrayList<>(Arrays.asList(
                sphereCenter.getZ(),
                intersectionPointOfCoordinatePlane.getZ()));


        Map<Boolean, List<Double>> conditionsToChooseCoordinates = new HashMap<>();
        conditionsToChooseCoordinates.put(intersectionPointOfCoordinatePlane.getZ() == 0 &&
                intersectionPointOfCoordinatePlane.getY() == 0, xOfCenterAndIntersectionPoint);
        conditionsToChooseCoordinates.put(intersectionPointOfCoordinatePlane.getZ() == 0 &&
                intersectionPointOfCoordinatePlane.getX() == 0, yOfCenterAndIntersectionPoint);
        conditionsToChooseCoordinates.put(intersectionPointOfCoordinatePlane.getX() == 0 &&
                intersectionPointOfCoordinatePlane.getY() == 0, zOfCenterAndIntersectionPoint);

        for (Boolean condition : conditionsToChooseCoordinates.keySet()) {
            if (condition) {
                heightOfSphericalCap = sphere.getRadius() -
                        Math.abs(
                                conditionsToChooseCoordinates.get(condition)
                                        .get(0) -
                                        conditionsToChooseCoordinates.get(condition)
                                                .get(1));
            }
        }
        double volumeOfSphericalCap = Math.PI *
                Math.pow(heightOfSphericalCap, 2) / 3 *
                (3 * sphere.getRadius() - heightOfSphericalCap);
        double volumeOfRemainingSphericalSegment = calculateVolume(sphere) - volumeOfSphericalCap;
        return volumeOfRemainingSphericalSegment / volumeOfSphericalCap;
    }
}
