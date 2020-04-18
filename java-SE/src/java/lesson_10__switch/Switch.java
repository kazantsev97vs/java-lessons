package lesson_10__switch;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите возраст");
        String age = scanner.nextLine();

        switch (age) {

            case "ноль":
                System.out.println("Ты родился");
                break;

            case "Семь":
                System.out.println("Ты пошел в школу");
                break;

            case "Восемнадцать":
                System.out.println("Ты закончил школу");
                break;

            default:
                System.out.println("Ни одно из предыдущих условий не подошло");

        }
    }
}
