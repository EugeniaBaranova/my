package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;

import java.util.Arrays;

public class IDSpecification implements Specification<Sphere>{

    private long volume;
    private SphereCalculator sphereCalculator = new SphereCalculator(new CommandProvider(),
            Arrays.asList(CoordinatePlane.OYZ,
                    CoordinatePlane.XOZ,
                    CoordinatePlane.XYO));

    public IDSpecification(long volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Sphere object) {
        return Long.compare(object.getId(), this.volume) == 0;
    }
}
