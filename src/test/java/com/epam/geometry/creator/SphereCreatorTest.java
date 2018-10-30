package com.epam.geometry.creator;

import com.epam.geometry.entity.Shape;
import com.epam.geometry.entity.Sphere;
import com.epam.geometry.creator.validator.ShapeValidator;
import com.epam.geometry.creator.validator.SphereValidator;
import com.epam.geometry.creator.validator.SphereValidationResult;
import com.epam.geometry.stringParser.PossibleSphereDataKeeper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SphereCreatorTest {

    private PossibleSphereDataKeeper TEST_DATA_KEEPER=
            new PossibleSphereDataKeeper(new ArrayDeque<>(Arrays.asList(1.1, -5.02, -6.2, 2.7)));

    private ShapeValidator sphereValidator = mock(SphereValidator.class);
    private SphereValidationResult validationResult = mock(SphereValidationResult.class);

    private ShapeCreator sphereCreator = new SphereCreator(sphereValidator);

    @Test
    public void shouldCreateSphereWhenGivenValidData() {
        //given
        when(validationResult.getError())
                .thenReturn(null);
        when(validationResult.getResult())
                .thenReturn(TEST_DATA_KEEPER);
        when(sphereValidator.validate(any(PossibleSphereDataKeeper.class)))
                .thenReturn(validationResult);
        List<PossibleSphereDataKeeper> parametersForSpheres = new ArrayList<>();
        parametersForSpheres.add(TEST_DATA_KEEPER);
        parametersForSpheres.add(TEST_DATA_KEEPER);
        //when
        List<? extends Shape> result = sphereCreator.create(parametersForSpheres);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertThat(TEST_DATA_KEEPER.getPossibleRadius(),
                is(((Sphere)result.get(0))
                        .getRadius()));
        Assert.assertThat(TEST_DATA_KEEPER.getPossibleXofCenter(),
                is(((Sphere)result.get(0))
                        .getCenter()
                        .getX()));
        Assert.assertThat(TEST_DATA_KEEPER.getPossibleRadius(),
                is(((Sphere)result.get(1))
                        .getRadius()));
    }

    @Test
    public void shouldNotCreateSphereWhenGivenInvalidData() {
        //given
        when(validationResult.getError()).thenReturn("Invalid radius");
        when(sphereValidator.validate(any(PossibleSphereDataKeeper.class))).thenReturn(validationResult);
        List<PossibleSphereDataKeeper> parametersForSpheres = new ArrayList<>();
        parametersForSpheres.add(TEST_DATA_KEEPER);
        parametersForSpheres.add(TEST_DATA_KEEPER);
        //when
        List<? extends Shape> result = sphereCreator.create(parametersForSpheres);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldNotCreateSphereWhenGivenEmptyList() {
        //given
        List<PossibleSphereDataKeeper> parametersForSpheres = new ArrayList<>();
        //when
        List<? extends Shape> result = sphereCreator.create(parametersForSpheres);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldNotCreateSphereWhenGivenNull() {
        //when
        List<? extends Shape> result = sphereCreator.create(null);
        //then
        Assert.assertTrue(result.isEmpty());
    }
}
