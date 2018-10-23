package com.epam.geometry.reader;

import com.epam.geometry.reader.exception.MissingDataException;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class DataReaderTest {

    private static final String NONEXISTENT_FILE_NAME = "xnjksdkv";
    private static final String FILE_NAME = "spheres_for_tests.txt";
    private static final String LINE_ONE_OF_TEST_FILE = "x=4; y=5; z=6; r=10";
    private static final String LINE_TWO_OF_TEST_FILE = "x=1; y=-5; z=-6; r=2";
    private static final String LINE_THREE_OF_TEST_FILE = "x=1.1; y=-5.02; z=-6.2; r=2.7";
    private static final String LINE_FOUR_OF_TEST_FILE = "x=1; y=-5; z=-6; r=0";
    private static final String LINE_FIVE_OF_TEST_FILE = "";
    private static final String LINE_SIX_OF_TEST_FILE = "x=4;y=5;z=6;r=10";
    private static final String LINE_SEVEN_OF_TEST_FILE = "x=4; y=5; z=6; r=-10";
    private static final String LINE_EIGHT_OF_TEST_FILE = "rty; y=5then ; z=6; r=10";

    private DataReader dataReader = new DataReader();

    @Test
    public void shouldReadFileAndReturnListOfStringsWhenDataIsFound() throws MissingDataException {
        //when
        List<String> result = dataReader.readLines(FILE_NAME);
        //then
        Assert.assertEquals(8, result.size());
        Assert.assertThat(LINE_ONE_OF_TEST_FILE, is(result.get(0)));
        Assert.assertThat(LINE_TWO_OF_TEST_FILE, is(result.get(1)));
        Assert.assertThat(LINE_THREE_OF_TEST_FILE, is(result.get(2)));
        Assert.assertThat(LINE_FOUR_OF_TEST_FILE, is(result.get(3)));
        Assert.assertThat(LINE_FIVE_OF_TEST_FILE, is(result.get(4)));
        Assert.assertThat(LINE_SIX_OF_TEST_FILE, is(result.get(5)));
        Assert.assertThat(LINE_SEVEN_OF_TEST_FILE, is(result.get(6)));
        Assert.assertThat(LINE_EIGHT_OF_TEST_FILE, is(result.get(7)));
    }

    @Test
    public void shouldReadFileAndReturnEmptyListExceptionWhenDataNotFound() throws MissingDataException {
        //when
        List<String> result = dataReader.readLines(NONEXISTENT_FILE_NAME);
        //then
        Assert.assertTrue(result.isEmpty());
    }


}
