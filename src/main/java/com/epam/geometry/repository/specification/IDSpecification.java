package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;

public class IDSpecification implements Specification<Sphere>{

    private long volume;

    public IDSpecification(long volume) {
        this.volume = volume;
    }

    @Override
    public boolean specified(Sphere object) {
        long id = object.getId();
        return Long.compare(id, volume) == 0;
    }
}
