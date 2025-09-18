package Lesson_7_junit_5;

import Lesson_7.Arithmetic;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticTest
{
    private Arithmetic arithmetic;

    @BeforeEach
    void setUp()
    {
        arithmetic = new Arithmetic();
    }

    @Test
    public void arithmeticTest()
    {
        assertEquals(12, arithmetic.addition(5, 7));
        assertEquals(-4.5, arithmetic.addition(-5, 0.5));
        assertEquals(0, arithmetic.subtraction(10, 10));
        assertEquals(6, arithmetic.subtraction(-0.5, -6.5));
        assertEquals(40, arithmetic.multiplication(5, 8));
        assertEquals(-10.98, arithmetic.multiplication(-6.1, 1.8));
        assertEquals(10, arithmetic.division(50, 5));
        assertEquals(-80.75, arithmetic.division(-80.75, 0));
    }
}
