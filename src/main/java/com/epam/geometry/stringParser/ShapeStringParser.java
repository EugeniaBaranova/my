package com.epam.geometry.stringParser;

import java.util.List;

public interface ShapeStringParser {

    List<? extends PossibleShapeDataKeeper> parseLines(List<String> validLines);

}
