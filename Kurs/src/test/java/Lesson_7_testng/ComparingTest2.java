package Lesson_7_testng;

import Lesson_7.Comparing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparingTest2
{
    private Comparing comparing;

    @BeforeEach
    void setUp() {
        comparing = new Comparing();
    }

    @Test
    public void comparingTestFirstGreater()
    {
        assertEquals("Первое число больше!", comparing.comparing(100, -100));
    }

    @Test
    public void comparingTestSecondGreater()
    {
        assertEquals("Второе число больше!", comparing.comparing(5, 6));
    }

    @Test
    public void comparingTestEqualNumbers()
    {
        assertEquals("Числа равны!", comparing.comparing(0, 0));
    }
}
