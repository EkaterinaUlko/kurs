package Lesson_7;

public class Comparing {
    public String comparing(int a, int b)
    {
        String result;
        if (a > b)
            result = "Первое число больше!";
        else if (a < b)
            result = "Второе число больше!";
        else
            result = "Числа равны!";
        System.out.println(result);
        return result;
    }
}
