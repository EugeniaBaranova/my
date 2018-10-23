package com.epam.geometry.stringParser;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;


public class SphereStringParserTest {

    private static final String CORRECT_LINE = "x=1.1; y=-5.02; z=-6.2; r=2.7";

    private PossibleSphereDataKeeper DATA_KEEPER_RECEIVED_FROM_CORRECT_LINE=
            new PossibleSphereDataKeeper(new ArrayDeque<>(Arrays.asList(1.1, -5.02, -6.2, 2.7)));

    private ShapeStringParser sphereStringParser = new SphereStringParser();

    @Test
    public void shouldParseLinesWhenGivenLines() {
        //given
        List<String> validLines = new ArrayList<>();
        validLines.add(CORRECT_LINE);
        validLines.add(CORRECT_LINE);
        //when
        List<? extends PossibleShapeDataKeeper> result = sphereStringParser.parseLines(validLines);
        //then
        Assert.assertEquals(2, result.size());
        Assert.assertThat(DATA_KEEPER_RECEIVED_FROM_CORRECT_LINE, is(result.get(0)));
        Assert.assertThat(DATA_KEEPER_RECEIVED_FROM_CORRECT_LINE, is(result.get(1)));
    }

    @Test
    public void shouldParseLinesAndNotGetLinesWhenGivenNull() {
        //when
        List<? extends PossibleShapeDataKeeper> result = sphereStringParser.parseLines(null);
        //then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void shouldValidateLineAndNotGetLineWhenGivenEmptyLinesList() {
        //given
        List<String> lines = new ArrayList<>();
        //when
        List<? extends PossibleShapeDataKeeper> result = sphereStringParser.parseLines(lines);
        //then
        Assert.assertTrue(result.isEmpty());
    }


}
