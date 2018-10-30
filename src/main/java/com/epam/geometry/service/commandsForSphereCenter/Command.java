package com.epam.geometry.service.commandsForSphereCenter;

import com.epam.geometry.entity.Sphere;

public interface Command {
    double execute(Sphere sphere);
}
