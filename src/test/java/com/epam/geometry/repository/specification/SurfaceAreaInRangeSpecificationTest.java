package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SurfaceAreaInRangeSpecificationTest {

    private SurfaceAreaInRangeSpecification surfaceAreaInRangeSpecification =
            new SurfaceAreaInRangeSpecification(10, 30);
    private Sphere sphere;

    @Before
    public void setUp(){
        sphere = new Sphere();
    }

    @Test
    public void shouldSpecifiedAndReturnTrueWhenSphereCorresponds() {
        //given
        sphere.setRadius(1);
        //when
        boolean result = surfaceAreaInRangeSpecification.specified(sphere);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldSpecifiedAndReturnFalseWhenSphereNotCorresponds() {
        //given
        sphere.setRadius(3);
        //when
        boolean result = surfaceAreaInRangeSpecification.specified(sphere);
        //then
        Assert.assertFalse(result);
    }
}
