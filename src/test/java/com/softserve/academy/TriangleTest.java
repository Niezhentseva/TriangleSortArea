package com.softserve.academy;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class TriangleTest {
    Triangle triangle;

    @DataProvider
    public static Object[][] attributesForArea() {
        return new Object[][]{
                {Triangle.createTriangle("one", 2.5, 2.5, 3.0), 3.0},
                {Triangle.createTriangle("two", 1, 1, 1), 0.4330},
                {Triangle.createTriangle("three", 300, 300, 150), 21785.5313},
                {Triangle.createTriangle("four", 15, 16, 17), 109.9818},
                {Triangle.createTriangle("five", 22.25, 23.25, 25.25), 238.7461},
        };
    }

    @After
    public void tearDown() {
        triangle = null;
    }

    @Test
    @UseDataProvider("attributesForArea")
    public void getAreaTest(Triangle triangle, double expected) {
        double delta = 0.0001;
        double actual = triangle.getArea();

        Assert.assertEquals(expected, actual, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleBuilder1() {
        triangle = Triangle.createTriangle("one", 0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleBuilder2() {
        triangle = Triangle.createTriangle("two", -1, -1, -1.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleBuilder3() {
        triangle = Triangle.createTriangle("three", 1, -1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleBuilder4() {
        triangle = Triangle.createTriangle("four", 3, 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTriangleBuilder5() {
        triangle = Triangle.createTriangle("five", 15, 2, 1);
    }

}