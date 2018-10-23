package com.epam.geometry.stringParser;

import java.util.Queue;

public class PossibleSphereDataKeeper implements PossibleShapeDataKeeper {

    private double possibleRadius;
    private double possibleXofCenter;
    private double possibleYofCenter;
    private double possibleZofCenter;

    public PossibleSphereDataKeeper(Queue<Double> possibleParameters) {
        this.possibleXofCenter = possibleParameters.poll();
        this.possibleYofCenter = possibleParameters.poll();
        this.possibleZofCenter = possibleParameters.poll();
        this.possibleRadius = possibleParameters.poll();
    }

    public double getPossibleRadius() {
        return possibleRadius;
    }

    public double getPossibleXofCenter() {
        return possibleXofCenter;
    }

    public double getPossibleYofCenter() {
        return possibleYofCenter;
    }

    public double getPossibleZofCenter() {
        return possibleZofCenter;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        PossibleSphereDataKeeper guest = (PossibleSphereDataKeeper) object;

        return possibleXofCenter == guest.possibleXofCenter &&
                possibleYofCenter == guest.possibleYofCenter &&
                possibleZofCenter == guest.possibleZofCenter &&
                possibleRadius == guest.possibleRadius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) possibleXofCenter;
        result = prime * result + (int) possibleYofCenter;
        result = prime * result + (int) possibleZofCenter;
        result = prime * result + (int) possibleRadius;
        return result;
    }
}
