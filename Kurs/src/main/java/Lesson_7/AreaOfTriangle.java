package Lesson_7;

public class AreaOfTriangle {
    public double areaOfTriangle(double a, double h)
    {
        if (a < 0 || h < 0)
            System.out.println("Стороны должны быть положительными!");
        if (a < 0)
            a *= -1;
        if (h < 0)
            h *= -1;
        if (a == 0 || h == 0)
            System.out.println("Фигуры не существует!");
        return a * h / 2;
    }
}
