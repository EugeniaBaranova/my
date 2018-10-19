package com.epam.geometry.model.service;

import com.epam.geometry.model.entity.Point;
import com.epam.geometry.model.entity.Sphere;
import com.epam.geometry.model.service.validator.SphereValidator;
import com.epam.geometry.model.service.validator.SphereValidatorImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class SphereCalculatorTest {

    private Sphere sphere = new Sphere();

    private CoordinatePlane coordinatePlaneIntersectingXAxis = new CoordinatePlane(new Point(1, 0, 0));
    private CoordinatePlane coordinatePlaneIntersectingYAxis = new CoordinatePlane(new Point(0, 1, 0));
    private CoordinatePlane coordinatePlaneIntersectingZAxis = new CoordinatePlane(new Point(0, 0, 1));

    private SphereValidator validator = new SphereValidatorImpl();

    private SphereCalculator sphereCalculator = new SphereCalculator(validator);
    private static final double SURFACE_AREA_WHEN_RADIUS_IS_FOUR = 201.06192982974676;
    private static final double SURFACE_AREA_WHEN_RADIUS_IS_TWO = 50.26548245743669;
    private static final double VOLUME_WHEN_RADIUS_IS_THREE = 113.09733552923255;
    private static final double VOLUME_WHEN_RADIUS_IS_TEN = 4188.790204786391;
    private static final double VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_X_AXIS = 1.8409090909090908;
    private static final double VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_Y_AXIS = 1;
    private static final double VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_Z_AXIS = 1;

    @Test(expected = ServiceException.class)
    public void shouldCalculateSurfaceAreaWhenRadiusIsNegative() {
        //when
        double result = getResultForSurfaceAreaTest(-4);
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateSurfaceAreaWhenRadiusIsZero() {
        //when
        double result = getResultForSurfaceAreaTest(0);
    }

    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsFour() {
        //when
        double result = getResultForSurfaceAreaTest(4);
        //then
        Assert.assertThat(SURFACE_AREA_WHEN_RADIUS_IS_FOUR, is(result));
    }

    @Test
    public void shouldCalculateSurfaceAreaWhenRadiusIsTwo() {
        //when
        double result = getResultForSurfaceAreaTest(2);
        //then
        Assert.assertThat(SURFACE_AREA_WHEN_RADIUS_IS_TWO, is(result));
    }

    private double getResultForSurfaceAreaTest(int radius) {
        sphere.setRadius(radius);
        return sphereCalculator.calculateSurfaceArea(sphere);
    }

    @Test
    public void test() {


        System.out.println();


    }


    @Test(expected = ServiceException.class)
    public void shouldCalculateVolumeWhenRadiusIsNegative() {
        //when
        double result = getResultForVolumeTest(-3);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_THREE, is(result));
    }

    @Test(expected = ServiceException.class)
    public void shouldCalculateVolumeWhenRadiusIsZero() {
        //when
        double result = getResultForVolumeTest(0);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_THREE, is(result));
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsThree() {
        //when
        double result = getResultForVolumeTest(3);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_THREE, is(result));
    }

    @Test
    public void shouldCalculateVolumeWhenRadiusIsTen() {
        //when
        double result = getResultForVolumeTest(10);
        //then
        Assert.assertThat(VOLUME_WHEN_RADIUS_IS_TEN, is(result));
    }

    private double getResultForVolumeTest(int radius) {
        sphere.setRadius(radius);
        return sphereCalculator.calculateVolume(sphere);
    }

    @Test
    public void shouldCalculateVolumeRatioAfterCrossSectionWhenPlaneIntersectsXAxis() {
        //when
        double result = getResultForVolumeRatioTest(new Point(3, 2, -2), 10,
                coordinatePlaneIntersectingXAxis);
        //then
        Assert.assertThat(VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_X_AXIS, is(result));
    }

    @Test
    @Ignore
    public void shouldCalculateVolumeRatioAfterCrossSectionWhenPlaneIntersectsYAxis() {
        //when
        double result = getResultForVolumeRatioTest(new Point(3, 2, -2), 10,
                coordinatePlaneIntersectingYAxis);
        //then
        Assert.assertThat(VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_Y_AXIS, is(result));
    }

    @Test
    @Ignore
    public void shouldCalculateVolumeRatioAfterCrossSectionWhenPlaneIntersectsZAxis() {
        //when
        double result = getResultForVolumeRatioTest(new Point(3, 2, -2), 10,
                coordinatePlaneIntersectingYAxis);
        //then
        Assert.assertThat(VOLUME_RATIO_AFTER_CROSS_SECTION_WHEN_PLANE_INTERSECTS_Z_AXIS, is(result));
    }

    private double getResultForVolumeRatioTest(Point center,int radius, CoordinatePlane coordinatePlane) {
        sphere.setCenter(center);
        sphere.setRadius(radius);
        return sphereCalculator.calculateVolumeRatioAfterCrossSection(sphere, coordinatePlane);
    }
}
