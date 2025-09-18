package Lesson_7;

public class Factorial {
    public int factorial(int n)
    {
        int result = 1;
        if  (n > 0)
        {
            for (int i = 1; i < n; i++)
            {
                result *= i;
            }
        }
        else if (n < 0)
        {
            System.out.println("Факториал определён только для неотрицательных целых чисел!");
        }
        return result;
    }
}
