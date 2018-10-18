package com.epam.geometry.model;

import com.epam.geometry.model.entity.Point;
import com.epam.geometry.model.entity.Sphere;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private Sphere sphere = new Sphere();
    private Calculator calculator = new Calculator();
    private static final double SURFACE_AREA_WHEN_RADIUS_IS_FOUR = Math.pow(4, 2) * Math.PI * 4;
    private static final double SURFACE_AREA_WHEN_RADIUS_IS_TWO = Math.pow(2, 2) * Math.PI * 4;
    private static final double VOLUME_WHEN_RADIUS_IS_THREE = Math.pow(3, 3) * Math.PI * 4 / 3;
    private static final double VOLUME_WHEN_RADIUS_IS_TEN = Math.pow(10, 3) * Math.PI * 4 / 3;
    private static final double VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_COORDINATE_PLANE_CROSSES_X_AXIS_AND_RADIUS_IS_TEN =
            (VOLUME_WHEN_RADIUS_IS_TEN - (Math.PI * 1408 / 3)) / (Math.PI * 1408 / 3) ;

    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsFour() {
        //given
        sphere.setRadius(4);
        //when
        double result = calculator.calculateSurfaceArea(sphere);
        //then
        Assert.assertEquals(SURFACE_AREA_WHEN_RADIUS_IS_FOUR, result, 0);
    }

    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsTwo() {
        sphere.setRadius(2);
        //when
        double result = calculator.calculateSurfaceArea(sphere);
        //then
        Assert.assertEquals(SURFACE_AREA_WHEN_RADIUS_IS_TWO, result, 0);
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsThree() {
        //given
        sphere.setRadius(3);
        //when
        double result = calculator.calculateVolume(sphere);
        //then
        Assert.assertEquals(VOLUME_WHEN_RADIUS_IS_THREE, result, 0);
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsTen() {
        //given
        sphere.setRadius(10);
        //when
        double result = calculator.calculateVolume(sphere);
        //then
        Assert.assertEquals(VOLUME_WHEN_RADIUS_IS_TEN, result, 0);
    }

    @Test
    public void shouldCalculateVolumeRatioAfterCrossSectionWhenCoordinatePlaneParallelToYAndZ() {
        //given
        Point centerOfSphere = new Point(3, 2, -2);
        sphere.setCenter(centerOfSphere);
        sphere.setRadius(10);
        Point intersectionPointWithCoordinateAxes = new Point(1, 0, 0);
        CoordinatePlane coordinatePlaneParallelToYAndZ = new CoordinatePlane(intersectionPointWithCoordinateAxes);
        //when
        double result = calculator.calculateVolumeRatioAfterCrossSection(sphere, coordinatePlaneParallelToYAndZ);
        //then
        Assert.assertEquals(VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_COORDINATE_PLANE_CROSSES_X_AXIS_AND_RADIUS_IS_TEN, result, 0);
    }
}
