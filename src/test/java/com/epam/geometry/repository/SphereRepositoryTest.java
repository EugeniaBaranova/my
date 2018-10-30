package com.epam.geometry.repository;

import com.epam.geometry.entity.Sphere;
import com.epam.geometry.repository.specification.Specification;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


public class SphereRepositoryTest {

    //TODO mock
    private final static Sphere FIRST_SPHERE = new Sphere();

    private Specification<Sphere> mockSpecification = Mockito.mock(Specification.class);

    private Repository<Sphere> repository = new SphereRepository();

    {
        FIRST_SPHERE.setRadius(3);
        repository.add(FIRST_SPHERE);
    }

    @Test
    public void shouldFindByVolumeWhenValueCorresponds() {
        //given
        when(mockSpecification.specified(any(Sphere.class))).thenReturn(Boolean.TRUE);
        //when
        Optional<List<Sphere>> result = repository.findBy(mockSpecification);
        //then
        Assert.assertTrue(result.isPresent());
        Assert.assertEquals(1, result.get()
                .size());
        Assert.assertThat(FIRST_SPHERE, is(result.get()
                .get(0)));
    }

    @Test
    public void shouldFindByVolumeWhenValueNotCorresponds() {
        //given
        when(mockSpecification.specified(any(Sphere.class))).thenReturn(Boolean.FALSE);
        //when
        Optional<List<Sphere>> result = repository.findBy(mockSpecification);
        //then
        Assert.assertFalse(result.isPresent());
    }

}
