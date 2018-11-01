package com.epam.geometry.sorter.comparator;

import com.epam.geometry.entity.Sphere;

import java.util.Comparator;


public class SphereIdComparator implements SphereComparator{

    @Override
    public Comparator<Sphere> compare(){
        return Comparator.comparingLong(s -> s.getId());
    }

}
