package com.epam.geometry.reader;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class SphereStringValidatorTest {

    private static final String CORRECT_LINE = "x=1.1; y=-5.02; z=-6.2; r=2.7";
    private static final String INCORRECT_LINE = "get y=5then z=6...; r=10";

    private StringValidator stringValidator = new SphereStringValidator();

    @Test
    public void shouldGetValidLineWhenLineHasCorrectFormat(){
        //given
        List<String> correctLines = new ArrayList<>();
        correctLines.add(CORRECT_LINE);
        //when
        List<String> result = stringValidator.getValidLines(correctLines);
        //then
        Assert.assertThat(CORRECT_LINE, is(result.get(0)));
    }

    @Test
    public void shouldValidateLineAndNotGetLineWhenLineHasIncorrectFormat(){
        //given
        List<String> incorrectLines = new ArrayList<>();
        incorrectLines.add(INCORRECT_LINE);
        //when
        List<String> result = stringValidator.getValidLines(incorrectLines);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldGetOnlyValidLinesWhenLinesHaveDifferentFormats(){
        //given
        List<String> linesWithDifferentFormats = new ArrayList<>();
        linesWithDifferentFormats.add(CORRECT_LINE);
        linesWithDifferentFormats.add(INCORRECT_LINE);
        //when
        List<String> result = stringValidator.getValidLines(linesWithDifferentFormats);
        //then
        Assert.assertEquals(1, result.size());
        Assert.assertThat(CORRECT_LINE, is(result.get(0)));
    }

    @Test
    public void shouldValidateLineAndNotGetLineWhenGivenEmptyLinesList(){
        //given
        List<String> incorrectLines = new ArrayList<>();
        //when
        List<String> result = stringValidator.getValidLines(incorrectLines);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldValidateLineAndNotGetLineWhenGivenNull(){
        //when
        List<String> result = stringValidator.getValidLines(null);
        //then
        Assert.assertTrue(result.isEmpty());
    }

}
