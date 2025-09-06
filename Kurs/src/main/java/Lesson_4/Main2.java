package Lesson_4;

public class Main2 {
    public interface figure
    {
        public abstract double perimeter();
        public abstract double area();
        public abstract String background();
        public abstract String border();
    }
    public static class Circle implements figure
    {
        double radius;

        public Circle(double radius)
        {
            this.radius = radius;
        }
        @Override
        public double perimeter()
        {
            return 2 * Math.PI * radius;
        }
        @Override
        public double area()
        {
            return Math.PI * radius * radius;
        }
        @Override
        public String background()
        {
            return "голубой";
        }
        @Override
        public String border()
        {
            return "синяя";
        }
    }
    public static class Rectangle implements figure
    {
        double width;
        double height;

        public Rectangle(double width, double height)
        {
            this.width = width;
            this.height = height;
        }
        @Override
        public double perimeter()
        {
            return 2 * (width + height);
        }
        @Override
        public double area()
        {
            return width * height;
        }
        @Override
        public String background()
        {
            return "фиолетовый";
        }
        @Override
        public String border()
        {
            return "розовая";
        }
    }
    public static class Triangle implements figure
    {
        double sideA;
        double sideB;
        double sideC;

        public Triangle(double sideA, double sideB, double sideC)
        {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
        @Override
        public double perimeter()
        {
            return sideA + sideB + sideC;
        }
        @Override
        public double area()
        {
            double p = (sideA + sideB + sideC) / 2;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
        @Override
        public String background()
        {
            return "жёлтый";
        }
        @Override
        public String border()
        {
            return "оранжевая";
        }
    }
    public static void main(String[] args)
    {
        Circle circle1 = new Circle(5);
        Rectangle rectangle1 = new Rectangle(3, 7);
        Triangle triangle1 = new Triangle(2, 4, 5);

        info("круга", circle1.perimeter(), circle1.area(), circle1.background(), circle1.border());
        info("прямоугольника", rectangle1.perimeter(), rectangle1.area(), rectangle1.background(), rectangle1.border());
        info("треугольника", triangle1.perimeter(), triangle1.area(), triangle1.background(), triangle1.border());
    }
    public static void info(String figure, double perimeter, double area, String background, String border)
    {
        System.out.println("Периметр " + figure + " = " + perimeter);
        System.out.println("Площадь " + figure + " = " + area);
        System.out.println("Фон у " + figure + " - " + background);
        System.out.println("Граница " + figure + " - " + border);
    }
}
