package lesson_37__exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) {

        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
            // e.printStackTrace();
        }

        System.out.println("После блока try..catch код продолжает свое выполнение");
    }

    public static void readFile () throws FileNotFoundException {
        File file = new File("");
        Scanner scanner = new Scanner(file);
    }
}
