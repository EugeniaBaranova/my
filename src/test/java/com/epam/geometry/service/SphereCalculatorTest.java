package com.epam.geometry.service;

import com.epam.geometry.entity.CoordinatePlane;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.service.commandsForVolumeRatio.CommandProvider;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class SphereCalculatorTest {

    private static final double SURFACE_AREA_WHEN_RADIUS_IS_FOUR = 201.06192982974676;
    private static final double SURFACE_AREA_WHEN_RADIUS_IS_TWO = 50.26548245743669;
    private static final double VOLUME_WHEN_RADIUS_IS_THREE = 84.82300164692441;
    private static final double VOLUME_WHEN_RADIUS_IS_TEN = 3141.592653589793;
    private static final double VOLUME_RATIO = 0.7636684303350969;

    private Sphere sphere;

    private SphereCalculator sphereCalculator;

    private CommandProvider commandProvider;


    @Before
    public void setUp() {

        commandProvider = new CommandProvider();
        sphereCalculator = new SphereCalculator(commandProvider,
                Arrays.asList(CoordinatePlane.OYZ,
                        CoordinatePlane.XOZ,
                        CoordinatePlane.XYO));
        sphere = new Sphere();

    }


    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsFour() {
        //given
        sphere.setRadius(4);
        //when
        double result = sphereCalculator.calculateSurfaceArea(sphere);
        //then
        Assert.assertThat(SURFACE_AREA_WHEN_RADIUS_IS_FOUR, is(result));
    }

    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsTwo() {
        //given
        sphere.setRadius(2);
        //when
        double result = sphereCalculator.calculateSurfaceArea(sphere);
        //then
        Assert.assertThat(SURFACE_AREA_WHEN_RADIUS_IS_TWO, is(result));
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateSurfaceAreaAndThrowServiceExceptionWhenRadiusIsNegative() {
        //given
        sphere.setRadius(-3);
        //when
        sphereCalculator.calculateSurfaceArea(sphere);
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateSurfaceAreaAndThrowServiceExceptionWhenRadiusIsZero() {
        //given
        sphere.setRadius(0);
        //when
        sphereCalculator.calculateSurfaceArea(sphere);
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateVolumeAndThrowServiceExceptionWhenRadiusIsNegative() {
        //given
        sphere.setRadius(-3);
        //when
        sphereCalculator.calculateVolume(sphere);
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateVolumeAndThrowServiceExceptionWhenRadiusIsZero() {
        //given
        sphere.setRadius(0);
        //when
        sphereCalculator.calculateVolume(sphere);
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsThree() {
        //given
        sphere.setRadius(3);
        //when
        double result = sphereCalculator.calculateVolume(sphere);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_THREE, is(result));
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsTen() {
        //given
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolume(sphere);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_TEN, is(result));
    }


    @Test
    public void shouldCalculateVolumeRatioWhenCrossPlaneIsOYZ() {
        //given
        sphere.setCenter(new Point(1, 1, 1));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.OYZ);
        //then
        Assert.assertThat(VOLUME_RATIO,is(result));
    }

    @Test
    public void shouldCalculateVolumeRatioWhenCrossPlaneIsXOZ() {
        //given
        sphere.setCenter(new Point(1, 1, 1));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.XOZ);
        //then
        Assert.assertThat(VOLUME_RATIO,is(result));
    }

    @Test
    public void shouldCalculateVolumeRatioWhenCrossPlaneIsXYO() {
        //given
        sphere.setCenter(new Point(1, 1, 1));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.XYO);
        //then
        Assert.assertThat(VOLUME_RATIO,is(result));
    }

    @Test
    public void shouldCalculateVolumeRatioAndReturnZeroWhenSphereDoesNotCrossPlaneXYO() {
        //given
        sphere.setCenter(new Point(11, 11, 11));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.XYO);
        //then
        Assert.assertThat(0.0,is(result));
    }

    @Test
    public void shouldCalculateVolumeRatioAndReturnZeroWhenSphereDoesNotCrossPlaneXOZ() {
        //given
        sphere.setCenter(new Point(11, 11, 11));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.XOZ);
        //then
        Assert.assertThat(0.0,is(result));
    }

    @Test
    public void shouldCalculateVolumeRatioAndReturnZeroWhenSphereDoesNotCrossPlaneOYZ() {
        //given
        sphere.setCenter(new Point(11, 11, 11));
        sphere.setRadius(10);
        //when
        double result = sphereCalculator.calculateVolumeRatio(sphere, CoordinatePlane.OYZ);
        //then
        Assert.assertThat(0.0,is(result));
    }


}
