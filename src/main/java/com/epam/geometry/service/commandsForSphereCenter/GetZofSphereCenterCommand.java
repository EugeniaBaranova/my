package com.epam.geometry.service.commandsForSphereCenter;

import com.epam.geometry.entity.Sphere;

public class GetZofSphereCenterCommand implements Command{
    @Override
    public double execute(Sphere sphere) {
        return sphere.getCenter()
                .getZ();
    }
}