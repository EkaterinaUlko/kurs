package Lesson_6;

import java.util.ArrayList;

public class Main
{
    public static class Student
    {
        //мя, группа, курс, оценки по предметам
        private String name;
        private String group;
        private int course;
        private int[] grades;

        public Student(String name, String group, int course, int[] grades)
        {
            this.name = name;
            this.group = group;
            this.course = course;
            this.grades = grades;
        }

        public String getName()
        {
            return name;
        }
        public int getCourse() { return course; }

        public double getAverageGrade()
        {
            double sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            sum /= grades.length;
            return sum;
        }

        public static void deleteStudents(ArrayList<Student> Students)
        {
            ArrayList<Student> list = new ArrayList<>(Students);
            for (Student student : list)
            {
                if (student.getAverageGrade() < 3)
                {
                    Students.remove(student);
                }
            }
        }

        public static void transfer(ArrayList<Student> Students)
        {
            for (Student student : Students)
            {
                if (student.getAverageGrade() >= 3)
                {
                    student.course++;
                }
            }
        }

        public static void printStudents(ArrayList<Student> Students, int course)
        {
            for (Student student : Students)
            {
                if (student.getCourse() == course)
                {
                    System.out.println(student.getName());
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] grades1 = {3, 4, 5, 4, 3}; int[] grades2 = {2, 2, 3, 2, 3}; int[] grades3 = {5, 5, 5, 4, 5};
        int[] grades4 = {5, 5, 5, 5, 5}; int[] grades5 = {3, 4, 3, 3, 3}; int[] grades6 = {5, 4, 5, 5, 4};
        Student student1 = new Student("Иван Иванович Иванов", "Программист", 1, grades1);
        Student student2 = new Student("Пётр Петрович Петров", "Программист", 1, grades2);
        Student student3 = new Student("Мария Романовна Романова", "Программист", 1, grades3);
        Student student4 = new Student("Роман Иванович Романенко", "Программист", 1, grades4);
        Student student5 = new Student("Ксения Константиновна Плут", "Программист", 1, grades5);
        Student student6 = new Student("Тимур Андреевич Комин", "Программист", 2, grades6);
        ArrayList<Student> Students = new ArrayList<>();
        Students.add(student1); Students.add(student2); Students.add(student3);
        Students.add(student4); Students.add(student5); Students.add(student6);
        Student.deleteStudents(Students);
        Student.transfer(Students);
        Student.printStudents(Students, 2);
    }
}
