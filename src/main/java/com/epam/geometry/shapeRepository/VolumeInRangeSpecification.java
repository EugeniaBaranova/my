package com.epam.geometry.shapeRepository;

import com.epam.geometry.entity.Sphere;

public class VolumeInRangeSpecification implements Specification<Sphere>{
    @Override
    public boolean specified(Sphere object) {
        return false;
    }
}
