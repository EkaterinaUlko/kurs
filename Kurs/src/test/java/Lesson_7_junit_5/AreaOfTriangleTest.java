package Lesson_7_junit_5;

import Lesson_7.AreaOfTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreaOfTriangleTest
{
    private AreaOfTriangle areaOfTriangle;

    @BeforeEach
    void setUp()
    {
        areaOfTriangle = new AreaOfTriangle();
    }

    @Test
    public void areaOfTriangleTest()
    {
        Assertions.assertEquals(7.5, areaOfTriangle.areaOfTriangle(5, 3));
        Assertions.assertEquals(24, areaOfTriangle.areaOfTriangle(12, 4));
        Assertions.assertEquals(3.5, areaOfTriangle.areaOfTriangle(-3, 4));
        Assertions.assertEquals(0, areaOfTriangle.areaOfTriangle(0, 1));
    }
}
