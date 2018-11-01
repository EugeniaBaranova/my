package com.epam.geometry.facade;

import com.epam.geometry.reader.DataReader;
import com.epam.geometry.reader.exception.MissingDataException;

public class Main {




    public static void main(String[] args) throws MissingDataException {

        DataReader dataReader = new DataReader();
        dataReader.readLines("spheres.txt")
                .get(20);





       /* DataReader dataReader = new DataReader();
        StringValidator sphereStringValidator = new SphereStringValidator();
        ShapeStringParser sphereStringParser = new SphereStringParser();
        SphereValidator sphereValidator = new SphereValidator();
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
        }*/


    }
}
