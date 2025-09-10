package Lesson_5;

class MyArraySizeException extends Exception
{
    public MyArraySizeException(String message)
    {
        super(message);
    }
}

class MyArrayDataException extends Exception
{
    public MyArrayDataException(String message)
    {
        super(message);
    }
}

public class Main
{

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException
    {
        if (array.length != 4 || array[0].length != 4)
        {
            throw new MyArraySizeException("Массив должен быть размером 4x4!");
        }

        int sum = 0;

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                try
                {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e)
                {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + (i + 1) + "][" + (j + 1) + "]");
                }
            }
        }

        return sum;
    }

    public static void main(String[] args)
    {
        String[][] testArray = { {"1", "2", "3", "4"},
                                 {"5", "6", "7", "8"},
                                 {"9", "10", "11", "12"},
                                 {"13", "14", "15", "16"} };
        try
        {
            int result = processArray(testArray);
            System.out.println("Сумма элементов массива: " + result);
        }
        catch (MyArraySizeException e)
        {
            System.err.println("Ошибка размера массива: " + e.getMessage());
        }
        catch (MyArrayDataException e)
        {
            System.err.println("Ошибка данных в массиве: " + e.getMessage());
        }
    }
}