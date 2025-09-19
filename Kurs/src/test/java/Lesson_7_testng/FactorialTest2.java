package Lesson_7_testng;

import Lesson_7.Factorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest2
{
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void factorialTestPositive()
    {
        assertEquals(6, factorial.factorial(3));
        assertEquals(720, factorial.factorial(6));
    }

    @Test
    public void factorialTestZero()
    {
        assertEquals(1, factorial.factorial(0));
    }

    @Test
    public void factorialTestNegative()
    {
        assertEquals(1, factorial.factorial(-1));
    }
}
