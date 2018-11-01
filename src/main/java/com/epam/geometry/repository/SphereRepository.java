package com.epam.geometry.repository;

import com.epam.geometry.entity.Sphere;
import com.epam.geometry.repository.specification.Specification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SphereRepository implements Repository<Sphere> {

    private Map<Long, Sphere> data = new HashMap<>();

    @Override
    public void add(Sphere sphere) {
        long id = sphere.getId();
        data.put(id, sphere);
    }

    @Override
    public void remove(Sphere sphere) {
        long id = sphere.getId();
        data.remove(id);
    }

    @Override
    public void update(Sphere sphere, long id) {
        data.replace(id, sphere);
    }

    @Override
    public Optional<List<Sphere>> findBy(Specification specification) {
        List<Sphere> spheres = data.values()
                .stream()
                .filter(o -> specification.specified(o))
                .collect(Collectors
                        .toList());
        if(spheres.isEmpty()){
            spheres = null;
        }
        return Optional.ofNullable(spheres);
    }

}
