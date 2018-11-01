package com.epam.geometry.sorter;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.sorter.comparator.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class SphereSorterIT {

    private List<Sphere> spheres = new ArrayList<>();
    private Sphere sphereOne;
    private Sphere sphereTwo;
    private Sphere sphereThree;

    private SphereSorter sphereSorter;

    @Before
    public void setUp() {
        sphereOne = new Sphere();
        sphereOne.setId(3);
        sphereOne.setCenter(new Point(1, 1, 1));
        sphereOne.setRadius(2);

        sphereTwo = new Sphere();
        sphereTwo.setId(2);
        sphereTwo.setCenter(new Point(-2, -2, -2));
        sphereTwo.setRadius(20);

        sphereThree = new Sphere();
        sphereThree.setId(1);
        sphereThree.setCenter(new Point(20, 20, 20));
        sphereThree.setRadius(1);

        spheres.add(sphereOne);
        spheres.add(sphereTwo);
        spheres.add(sphereThree);
    }


    @Test
    public void shouldSortByIdWhenGivenSpheres() {
        //given
        sphereSorter = new SphereSorter(new SphereIdComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(spheres);
        //then
        Assert.assertThat(
                result.size(), is(3));
        Assert.assertThat(
                result.get(0), is(sphereThree));
        Assert.assertThat(
                result.get(1), is(sphereTwo));
        Assert.assertThat(
                result.get(2), is(sphereOne));
    }

    @Test
    public void shouldSortByRadiusWhenGivenSpheres() {
        //given
        sphereSorter = new SphereSorter(new SphereRadiusComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(spheres);
        //then
        Assert.assertThat(
                result.size(), is(3));
        Assert.assertThat(
                result.get(0), is(sphereThree));
        Assert.assertThat(
                result.get(1), is(sphereOne));
        Assert.assertThat(
                result.get(2), is(sphereTwo));
    }

    @Test
    public void shouldSortByXofCenterWhenGivenSpheres() {
        //given
        sphereSorter = new SphereSorter(new SphereXofCenterComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(spheres);
        //then
        Assert.assertThat(
                result.size(), is(3));
        Assert.assertThat(
                result.get(0), is(sphereTwo));
        Assert.assertThat(
                result.get(1), is(sphereOne));
        Assert.assertThat(
                result.get(2), is(sphereThree));
    }

    @Test
    public void shouldSortByYofCenterWhenGivenSpheres() {
        //given
        sphereSorter = new SphereSorter(new SphereYofCenterComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(spheres);
        //then
        Assert.assertThat(
                result.size(), is(3));
        Assert.assertThat(
                result.get(0), is(sphereTwo));
        Assert.assertThat(
                result.get(1), is(sphereOne));
        Assert.assertThat(
                result.get(2), is(sphereThree));
    }

    @Test
    public void shouldSortByZofCenterWhenGivenSpheres() {
        //given
        sphereSorter = new SphereSorter(new SphereZofCenterComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(spheres);
        //then
        Assert.assertThat(
                result.size(), is(3));
        Assert.assertThat(
                result.get(0), is(sphereTwo));
        Assert.assertThat(
                result.get(1), is(sphereOne));
        Assert.assertThat(
                result.get(2), is(sphereThree));
    }

    @Test
    public void shouldNotSortByWhenGivenNull() {
        //given
        sphereSorter = new SphereSorter(new SphereIdComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(null);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldNotSortByWhenGivenEmptyList() {
        //given
        sphereSorter = new SphereSorter(new SphereIdComparator());
        //when
        List<Sphere> result = sphereSorter.sortBy(new ArrayList<>());
        //then
        Assert.assertTrue(result.isEmpty());
    }


}
