package com.epam.geometry.service.commandsForVolumeRatio;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;

public class GetXofSphereCenterCommand implements Command {
    @Override
    public double execute(Sphere sphere) {
        return sphere.getCenter()
                .getX();
    }
}
