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
        double currentVolume = Math.sqrt(
                Math.pow(center
                        .getX(), 2)
                        + Math.pow(center
                        .getY(), 2)
                        + Math.pow(center
                        .getZ(), 2));
        return Double.compare(currentVolume, minVolume) >= 0 && Double.compare(currentVolume, maxVolume) <= 0;
    }
}
