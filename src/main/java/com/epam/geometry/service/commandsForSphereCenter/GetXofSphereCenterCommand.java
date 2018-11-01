package com.epam.geometry.service.commandsForSphereCenter;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;

public class GetXofSphereCenterCommand implements Command {
    @Override
    public double execute(Sphere sphere) {
        Point center = sphere.getCenter();
        return center.getX();
    }
}
