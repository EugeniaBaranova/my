package com.epam.geometry.model.service;

import com.epam.geometry.model.entity.Point;

public class CoordinatePlane {
    private Point intersectionWithAxis;

    public CoordinatePlane(Point intersectionWithAxis) {
        this.intersectionWithAxis = intersectionWithAxis;
    }

    public Point getIntersectionWithAxis() {
        return intersectionWithAxis;
    }

    public void setIntersectionWithAxis(Point intersectionWithAxis) {
        this.intersectionWithAxis = intersectionWithAxis;
    }
}
