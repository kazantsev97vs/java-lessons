package lesson_8__do_while;

import java.util.Scanner;

public class DoWhile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введи 5");
//        int value = scanner.nextInt();

//        while (value != 5) {
//            System.out.println("Введи 5");
//            value = scanner.nextInt();
//        }


        int value;

        do {

            System.out.println("Введи 5");
            value = scanner.nextInt();

        } while (value != 5);

        System.out.println("Вы  ввели 5!");
    }
}
