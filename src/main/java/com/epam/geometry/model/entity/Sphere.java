package com.epam.geometry.model.entity;

public class Sphere {
    private Point center;
    private double radius;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere: center = " + this.getCenter() + ", radius = " + this.getRadius();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Sphere guest = (Sphere) object;

        return center.equals(guest.center) && radius == guest.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + center.hashCode();
        result = prime * result + (int) radius;
        return result;
    }
}
