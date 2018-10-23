package com.epam.geometry.service.commandsForVolumeRatio;

import com.epam.geometry.entity.Sphere;

public interface Command {
    double execute(Sphere sphere);
}
