package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VolumeGreaterThenSpecificationTest {

    private VolumeGreaterThenSpecification volumeGreaterThenSpecification =
            new VolumeGreaterThenSpecification(80);
    private Sphere sphere;

    @Before
    public void setUp(){
        sphere = new Sphere();
    }

    @Test
    public void shouldSpecifiedAndReturnTrueWhenSphereCorresponds() {
        //given
        sphere.setRadius(10);
        //when
        boolean result = volumeGreaterThenSpecification.specified(sphere);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldSpecifiedAndReturnFalseWhenSphereNotCorresponds() {
        //given
        sphere.setRadius(2);
        //when
        boolean result = volumeGreaterThenSpecification.specified(sphere);
        //then
        Assert.assertFalse(result);
    }
}
