package com.epam.geometry.sorter.comparator;

import com.epam.geometry.entity.Sphere;

import java.util.Comparator;

public class SphereXofCenterComparator implements SphereComparator{

    @Override
    public Comparator<Sphere> compare(){
        return Comparator.comparingDouble(s -> s.getCenter()
                .getX());
    }
}
