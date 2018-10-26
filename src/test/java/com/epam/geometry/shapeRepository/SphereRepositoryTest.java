package com.epam.geometry.shapeRepository;

import com.epam.geometry.entity.Sphere;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class SphereRepositoryTest {


    //do mock
    private final static Sphere FIRST_SPHERE = new Sphere();

    private Repository<Sphere> repository = new SphereRepository();

    {
        FIRST_SPHERE.setRadius(3);
        repository.add(FIRST_SPHERE);
    }

    @Test
    public void shouldFindByVolume() {
        Specification<Sphere> mock = Mockito.mock(Specification.class);
        List<Sphere> result = repository.findBy(new VolumeGreaterThenSpecification(5));

        Assert.assertEquals(1, result.size());
        Assert.assertThat(FIRST_SPHERE, is(result.get(0)));


    }





}
