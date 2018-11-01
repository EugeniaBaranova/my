package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;

public class DistanceCenterOriginInRangeSpecification implements Specification<Sphere> {

    private double minVolume;
    private double maxVolume;

    public DistanceCenterOriginInRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Sphere object) {
        Point center = object.getCenter();
        double x = center.getX();
        double y = center.getY();
        double z = center.getZ();

        double squareX = Math.pow(x, 2);
        double squareY = Math.pow(y, 2);
        double squareZ = Math.pow(z, 2);

        double currentVolume = Math.sqrt(squareX + squareY + squareZ);

        return Double.compare(currentVolume, minVolume) >= 0
                && Double.compare(currentVolume, maxVolume) <= 0;
    }
}
