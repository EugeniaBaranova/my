package com.epam.geometry.repository.specification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DistanceCenterOriginInRangeSpecificationTest {

    private DistanceCenterOriginInRangeSpecification distanceInRangeSpecification =
            new DistanceCenterOriginInRangeSpecification(1, 10);
    private Sphere sphere;

    @Before
    public void setUp(){
        sphere = new Sphere();
    }

    @Test
    public void shouldSpecifiedAndReturnTrueWhenSphereCorresponds() {
        //given
        sphere.setCenter(new Point(3, 3, 3));
        //when
        boolean result = distanceInRangeSpecification.specified(sphere);
        //then
        Assert.assertTrue(result);
    }

    @Test
    public void shouldSpecifiedAndReturnFalseWhenSphereNotCorresponds() {
        //given
        sphere.setCenter(new Point(20, 20, 20));
        //when
        boolean result = distanceInRangeSpecification.specified(sphere);
        //then
        Assert.assertFalse(result);
    }

}
