package com.epam.geometry.sorter.comparator;

import com.epam.geometry.entity.Sphere;

import java.util.Comparator;

public interface SphereComparator {

    Comparator<Sphere> compare();
}
