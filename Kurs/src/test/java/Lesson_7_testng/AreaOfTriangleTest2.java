package Lesson_7_testng;

import Lesson_7.AreaOfTriangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaOfTriangleTest2
{
    private AreaOfTriangle areaOfTriangle;

    @BeforeEach
    void setUp()
    {
        areaOfTriangle = new AreaOfTriangle();
    }

    @Test
    public void areaOfTriangleTestPositive()
    {
        assertEquals(7.5, areaOfTriangle.areaOfTriangle(5, 3));
        assertEquals(24, areaOfTriangle.areaOfTriangle(12, 4));
    }

    @Test
    public void areaOfTriangleTestZero()
    {
        assertEquals(0, areaOfTriangle.areaOfTriangle(0, 1));
    }

    @Test
    public void areaOfTriangleTestNegative()
    {
        assertEquals(3.5, areaOfTriangle.areaOfTriangle(-3, 4));
    }
}
