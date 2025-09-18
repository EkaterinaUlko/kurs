package Lesson_7_junit_5;

import Lesson_7.Factorial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest
{
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    public void factorialTest()
    {
        assertEquals(1, factorial.factorial(0));
        assertEquals(6, factorial.factorial(3));
        assertEquals(720, factorial.factorial(6));
        assertEquals(1, factorial.factorial(-1));
    }
}
