package com.epam.geometry.shapeRepository;

import com.epam.geometry.entity.Sphere;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere> {

    private Map<Long, Sphere> data = new HashMap<>();

    @Override
    public void add(Sphere object) {
        data.put(object.getId(), object);
    }

    @Override
    public void remove(Sphere object) {
        data.remove(object.getId());
    }

    @Override
    public void update(Sphere object, long id) {
        data.replace(id, object);
    }

    @Override
    public Optional<List<Sphere>> findBy(Specification specification) {
        List<Sphere> spheres = data.values().stream()
                .filter(o -> specification.specified(o))
                .collect(Collectors.toList());
        return Optional.ofNullable(spheres);
    }
}
