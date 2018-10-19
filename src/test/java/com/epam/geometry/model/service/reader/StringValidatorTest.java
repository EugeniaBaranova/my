package com.epam.geometry.model.service.reader;

import org.junit.Assert;
import org.junit.Test;

public class StringValidatorTest {

    private StringValidator stringValidator = new StringValidator();

    @Test
    public void shouldValidateStringWhenStringHasCorrectFormat(){
        //when
        boolean validationResult = stringValidator.validateString("x=5.5; y=-6.3; z=6; r=8");
        //then
        Assert.assertTrue(validationResult);
    }

    @Test
    public void shouldValidateStringWhenStringHasNegativeRadius(){
        //when
        boolean validationResult = stringValidator.validateString("x=5.5; y=-6.3; z=6; r=-8");
        //then
        Assert.assertFalse(validationResult);
    }

    @Test
    public void shouldValidateStringWhenStringHasZeroRadius(){
        //when
        boolean validationResult = stringValidator.validateString("x=5.5; y=-6.3; z=6; r=0");
        //then
        Assert.assertFalse(validationResult);
    }

    @Test
    public void shouldValidateStringWhenStringWithoutSpacesAfterSemicolons(){
        //when
        boolean validationResult = stringValidator.validateString("x=5.5;y=-6.3;z=6;r=8");
        //then
        Assert.assertFalse(validationResult);
    }

    @Test
    public void shouldValidateStringWhenStringWithTooManySpacesAfterSemicolons(){
        //when
        boolean validationResult = stringValidator.validateString("x=5.5;    y=-6.3;    z=6;     r=8");
        //then
        Assert.assertFalse(validationResult);
    }

    @Test
    public void shouldValidateStringWhenEmptyString(){
        //when
        boolean validationResult = stringValidator.validateString("");
        //then
        Assert.assertFalse(validationResult);
    }

}
