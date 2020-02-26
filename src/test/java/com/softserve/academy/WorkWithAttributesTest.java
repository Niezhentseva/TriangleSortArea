package com.softserve.academy;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class WorkWithAttributesTest {

    @DataProvider
    public static Object[][] checkQuantityAttributes() {
        return new Object[][]{
                {"one, 1.5, 1.45, 1.45", true},
                {"two, 2, 2", false},
                {"three, 2,2,  2", true},
                {"four, 1", false},
                {"five, 3,3,3", true},
                {"six, 30.5  , 30.6,   30.6", true},
                {"seven, 300,300,300", true},
                {"eight, 2.55,2.55  ,2.65", true},
                {"nine, 3,3,3,3", false},
                {"ten", false}
        };
    }

    @DataProvider
    public static Object[][] checkParseAttributes() {
        return new Object[][]{
                {"one, 1.5, 1.45, 1.45", new String[]{"one", "1.5", "1.45", "1.45"}},
                {"two, -1, -1,-1", new String[]{"two", "-1", "-1", "-1"}},
                {"three, 2,2,  2", new String[]{"three", "2", "2", "2"}},
                {"four, 0,0     ,0", new String[]{"four", "0", "0", "0"}},
                {"five, 3,3,3", new String[]{"five", "3", "3", "3"}},
                {"six, 30.5  , 30.6,   30.6", new String[]{"six", "30.5", "30.6", "30.6"}},
                {"seven, 300,300,300", new String[]{"seven", "300", "300", "300"}},
                {"eight, 2.55,2.55  ,2.65", new String[]{"eight", "2.55", "2.55", "2.65"}},
                {"nine, a,b,c", new String[]{"nine", "a", "b", "c"}},
                {"ten, /, =, ?", new String[]{"ten", "/", "=", "?"}}
        };
    }
    @Test
    @UseDataProvider("checkQuantityAttributes")
    public void isForCommasTest(String input, boolean expected) {
        boolean actual = WorkWithAttributes.isForCommas(input);

        assertEquals(expected, actual);
    }
    @Test
    @UseDataProvider("checkParseAttributes")
    public void parseInputTest(String input, String[] expected) {
        String[] actual = WorkWithAttributes.parseInput(input);
        assertArrayEquals(expected, actual);
    }
}