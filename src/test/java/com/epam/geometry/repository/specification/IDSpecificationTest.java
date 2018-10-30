package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDSpecificationTest {

    private IDSpecification idSpecification =
            new IDSpecification(3);
    private Sphere sphere;

    @Before
    public void setUp(){
        sphere = new Sphere();
    }

    @Test
    public void shouldSpecifiedAndReturnTrueWhenSphereCorresponds() {
        //given
        sphere.setId(3);
        //when
        boolean result = idSpecification.specified(sphere);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldSpecifiedAndReturnFalseWhenSphereNotCorresponds() {
        //given
        sphere.setId(4);
        //when
        boolean result = idSpecification.specified(sphere);
        //then
        Assert.assertFalse(result);
    }
}
