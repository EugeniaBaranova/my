package com.epam.geometry.service.commandsForVolumeRatio;

import com.epam.geometry.entity.Sphere;

public class GetYofSphereCenterCommand implements Command {
    @Override
    public double execute(Sphere sphere) {
        return sphere.getCenter()
                .getY();
    }
}