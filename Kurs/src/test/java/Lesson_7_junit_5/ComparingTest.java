package Lesson_7_junit_5;

import Lesson_7.Comparing;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparingTest
{
    private Comparing comparing;

    @BeforeEach
    void setUp() {
        comparing = new Comparing();
    }

    @Test
    public void comparingTest()
    {
        assertEquals("Числа равны!", comparing.comparing(0, 0));
        assertEquals("Первое число больше!", comparing.comparing(100, -100));
        assertEquals("Второе число больше!", comparing.comparing(5, 6));
    }
}
