package Lesson_7_junit_5;

import Lesson_7.AreaOfTriangle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(7.5, areaOfTriangle.areaOfTriangle(5, 3));
        assertEquals(24, areaOfTriangle.areaOfTriangle(12, 4));
    }
}
