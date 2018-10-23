package com.epam.geometry.creator;

import com.epam.geometry.entity.Shape;
import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;

import java.util.List;

public interface ShapeCreator {

    List<? extends Shape> create(List<? extends PossibleShapeDataKeeper> parametersForSpheres);

}
