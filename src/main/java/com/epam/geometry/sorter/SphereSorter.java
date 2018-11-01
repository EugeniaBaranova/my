package com.epam.geometry.sorter;

import com.epam.geometry.entity.Sphere;
import com.epam.geometry.sorter.comparator.SphereComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SphereSorter {

    private SphereComparator sphereComparator;

    public SphereSorter(SphereComparator sphereComparator) {
        this.sphereComparator = sphereComparator;
    }

    public List<Sphere> sortBy(List<Sphere> spheres) {
        List<Sphere> sortedSpheres = new ArrayList<>();
        if (spheres != null) {
            sortedSpheres = spheres
                    .stream()
                    .sorted(sphereComparator
                            .compare())
                    .collect(Collectors.toList());
        }
        return sortedSpheres;
    }

}
