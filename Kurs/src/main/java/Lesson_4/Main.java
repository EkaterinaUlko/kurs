package Lesson_4;

public class Main {
    public static class Animal
    {
        String name;
        int animalCount = 0;

        public Animal(String name)
        {
            this.name = name;
            animalCount++;
        }
        public void run(int s)
        {
            System.out.println(name + " пробежал " + s + " м.");
        }
        public void swim(int s)
        {
            System.out.println(name + " проплыл " + s + " м.");
        }
    }
    public static class Cat extends Animal
    {
        int catCount = 0;
        boolean satiety = false;
        int food = 10;

        public Cat(String name)
        {
            super(name);
            catCount++;
        }
        @Override
        public void run(int s)
        {
            if (s <= 200)
            {
                super.run(s);
            }
            else
            {
                System.out.println(name + " не может пробежать " + s + " м. (максимум 200 м.)");
            }
        }
        @Override
        public void swim(int s)
        {
            System.out.println(name + " не умеет плавать!");
        }
    }
    public static class Dog extends Animal
    {
        int dogCount = 0;

        public Dog(String name)
        {
            super(name);
            dogCount++;
        }
        @Override
        public void run(int s)
        {
            if (s <= 500)
            {
                super.run(s);
            }
            else
            {
                System.out.println(name + " не может пробежать " + s + " м. (максимум 500 м.)");
            }
        }
        @Override
        public void swim(int s)
        {
            if (s <= 10)
            {
                super.swim(s);
            }
            else
            {
                System.out.println(name + " не может проплыть " + s + " м. (максимум 10 м.)");
            }
        }
    }
    public static class Bowl
    {
        int count = 0;
        String name;

        public Bowl(String name)
        {
            this.name = name;
        }
        public void put(int c)
        {
            count += c;
            System.out.println("В миске " + name + " стало " + count + " корма.");
        }
        public void eat(Cat Cat)
        {
            if (count - Cat.food >= 0)
            {
                Cat.satiety = true;
                System.out.println("Кот " + Cat.name + " сыт!");
                count -= Cat.food;
                System.out.println("В миске " + name + " осталось " + count + " корма.");
            }
            else
            {
                System.out.println("В миске " + name + count + " корма (для питания кота нужно " + Cat.food + ")!");
            }
        }
    }
    public static void main(String[] args)
    {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Рыжик");
        Bowl bowl1 = new Bowl("Кошачья Мисочка");
        bowl1.put(20);
        Cat[] cats = {cat1, cat2, cat3};
        for (int i = 0; i < cats.length; i++)
        {
            if (bowl1.count > 0)
            {
                bowl1.eat(cats[i]);
            }
            else
            {
                System.out.println("Еда в миске " + bowl1.name + " закончилась!");
                break;
            }
        }
        System.out.println("Все ли коты сыты?");
        for (int i = 0; i < cats.length; i++)
        {
            if (cats[i].satiety == true)
            {
                System.out.println(cats[i].name + " сыт!");
            }
            else
            {
                System.out.println(cats[i].name + " голоден!");
            }
        }
    }
}
