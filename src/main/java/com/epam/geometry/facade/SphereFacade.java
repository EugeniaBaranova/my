package com.epam.geometry.facade;

import com.epam.geometry.creator.ShapeCreator;
import com.epam.geometry.creator.SphereCreator;
import com.epam.geometry.creator.validator.SphereValidator;
import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.reader.SphereStringValidator;
import com.epam.geometry.reader.StringValidator;
import com.epam.geometry.reader.exception.MissingDataException;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForSphereCenter.CommandProvider;
import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.ShapeStringParser;
import com.epam.geometry.stringParser.impl.SphereStringParser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SphereFacade {

    private DataReader dataReader = new DataReader();
    private StringValidator sphereStringValidator = new SphereStringValidator();
    private ShapeStringParser sphereStringParser = new SphereStringParser();
    private SphereValidator sphereValidator = new SphereValidator();
    private ShapeCreator sphereCreator = new SphereCreator(sphereValidator);

    public List<Sphere> receiveSpheresFromFile(String fileName) throws MissingDataException {

        List<String> lines = dataReader.readLines(fileName);
        List<String> validLines = sphereStringValidator.getValidLines(lines);
        List<? extends PossibleShapeDataKeeper> possibleShapeDataKeepers =
                sphereStringParser.parseLines(validLines);
        return (List<Sphere>) sphereCreator.create(possibleShapeDataKeepers);

    }
}
