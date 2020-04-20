package lesson_39__exceptions___checked_unchecked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Checked и Unchecked Exceptions
 * Проверяемые и Непроверяемые Исключения
 *
 * Checked (Проверяемые) - Compile time exception (Исключения, которые возникают во время компиляции)
 *                         === исключительные случаи в работе программы
 *
 * Unchecked (Непроверяемые) - RunTime exception (Исключения, которые возникают во время выполнения программы)
 *                           === ошибка в работе программы (их нужно исправлять)
 *
 */
public class Exceptions {

    public static void main(String[] args) {

        File file = new File("");

        // Checked exception:
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        // Unchecked exception:
        // int a = 1 / 0;               ArithmeticException: / by zero

        String name = null;
        // name.length();               NullPointerException

        int[] arr = new int[2];
        // System.out.println(arr[2]);  ArrayIndexOutOfBoundsException: 2

    }

}
