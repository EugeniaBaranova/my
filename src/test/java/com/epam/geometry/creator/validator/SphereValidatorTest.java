package com.epam.geometry.creator.validator;

import com.epam.geometry.stringParser.impl.PossibleSphereDataKeeper;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;

public class SphereValidatorTest {

    private PossibleSphereDataKeeper VALID_DATA_KEEPER=
            new PossibleSphereDataKeeper(new ArrayDeque<>(Arrays.asList(1.1, -5.02, -6.2, 2.7)));
    private PossibleSphereDataKeeper INVALID_DATA_KEEPER=
            new PossibleSphereDataKeeper(new ArrayDeque<>(Arrays.asList(1.1, -5.02, -6.2, 0.0)));

    private SphereValidator sphereValidator = new SphereValidator();

    @Test
    public void shouldValidateAndGetResultWithDataKeeperWhenGivenValidData() {
        //when
        SphereValidationResult result = sphereValidator.validate(VALID_DATA_KEEPER);
        //then
        Assert.assertThat(VALID_DATA_KEEPER, is(result.getResult()));
    }

    @Test
    public void shouldValidateAndGetResultWithoutDataKeeperWhenGivenInvalidData() {
        //when
        SphereValidationResult result = sphereValidator.validate(INVALID_DATA_KEEPER);
        //then
        Assert.assertThat(null, is(result.getResult()));
        Assert.assertThat("Invalid radius 0.0", is(result.getError()));
    }

    @Test
    public void shouldValidateAndGetResultWithoutDataKeeperWhenGivenNull() {
        //when
        SphereValidationResult result = sphereValidator.validate(null);
        //then
        Assert.assertThat(new SphereValidationResult(), is(result));
    }

}
