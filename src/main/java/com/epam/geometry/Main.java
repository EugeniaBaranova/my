package com.epam.geometry;

import com.epam.geometry.creator.ShapeCreator;
import com.epam.geometry.creator.SphereCreator;
import com.epam.geometry.creator.validator.ShapeValidator;
import com.epam.geometry.creator.validator.SphereValidator;
import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.reader.DataReader;
import com.epam.geometry.reader.SphereStringValidator;
import com.epam.geometry.reader.StringValidator;
import com.epam.geometry.reader.exception.MissingDataException;
import com.epam.geometry.service.SphereCalculator;
import com.epam.geometry.service.commandsForVolumeRatio.CommandProvider;
import com.epam.geometry.stringParser.PossibleShapeDataKeeper;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;
import com.epam.geometry.stringParser.ShapeStringParser;
import com.epam.geometry.stringParser.SphereStringParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DataReader dataReader = new DataReader();
        StringValidator sphereStringValidator = new SphereStringValidator();
        ShapeStringParser sphereStringParser = new SphereStringParser();
        ShapeValidator sphereValidator = new SphereValidator();
        ShapeCreator sphereCreator = new SphereCreator(sphereValidator);
        CommandProvider commandProvider = new CommandProvider();
        List<CoordinatePlane> coordinatePlanes = Arrays.asList(
                CoordinatePlane.OYZ,
                CoordinatePlane.XOZ,
                CoordinatePlane.OYZ);
        SphereCalculator sphereCalculator = new SphereCalculator(commandProvider, coordinatePlanes);

        try {
            List<String> lines = dataReader.readLines("spheres.txt");
            List<String> validLines = sphereStringValidator.getValidLines(lines);
            List<? extends PossibleShapeDataKeeper> sphereDataKeepers = sphereStringParser.parseLines(validLines);
            List<? extends Shape> spheres = sphereCreator.create(sphereDataKeepers);
            Iterator<? extends Shape> iterator = spheres.iterator();
            if (iterator.hasNext()) {
                Sphere sphere = (Sphere) spheres.get(0);
                System.out.println(sphereCalculator.doesContactWithPlane(sphere, CoordinatePlane.OYZ));
                System.out.println(sphereCalculator.calculateVolume(sphere));
            }
        } catch (MissingDataException e) {
            e.printStackTrace();
        }


    }
}
