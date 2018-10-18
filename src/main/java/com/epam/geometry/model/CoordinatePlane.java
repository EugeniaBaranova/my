package com.epam.geometry.model;

import com.epam.geometry.model.entity.Point;

public class CoordinatePlane {
    private Point intersectionPointWithCoordinateAxes;

    public CoordinatePlane(Point intersectionPointWithCoordinateAxes) {
        this.intersectionPointWithCoordinateAxes = intersectionPointWithCoordinateAxes;
    }

    public Point getIntersectionPointWithCoordinateAxes() {
        return intersectionPointWithCoordinateAxes;
    }

    public void setIntersectionPointWithCoordinateAxes(Point intersectionPointWithCoordinateAxes) {
        this.intersectionPointWithCoordinateAxes = intersectionPointWithCoordinateAxes;
    }
}
