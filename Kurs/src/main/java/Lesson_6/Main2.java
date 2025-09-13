package Lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2
{
    public static class PhoneBook
    {
        private Map<String, ArrayList<String>> phoneBook;

        public void addPhone(String surname, String phoneNumber)
        {
            if (!phoneBook.containsKey(surname))
            {
                phoneBook.put(surname, new ArrayList<>());
            }
            phoneBook.get(surname).add(phoneNumber);
        }

        public PhoneBook()
        {
            phoneBook = new HashMap<>();
        }

        public ArrayList<String> getPhoneBook(String surname)
        {
            return phoneBook.getOrDefault(surname, new ArrayList<>());
        }
    }

    public static void main(String[] args)
    {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addPhone("Иванов", "8 888 888 88-88");
        phoneBook.addPhone("Иванов", "9 999 999 99-99");
        phoneBook.addPhone("Петров", "7 777 777 77-77");
        phoneBook.addPhone("Сидоров", "6 666 666 66-66");
        System.out.println("Телефоны Иванов: " + phoneBook.getPhoneBook("Иванов"));
        System.out.println("Телефоны Петров: " + phoneBook.getPhoneBook("Петров"));
        System.out.println("Телефоны Сидоров: " + phoneBook.getPhoneBook("Сидоров"));
    }
}
