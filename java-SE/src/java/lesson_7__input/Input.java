package lesson_7__input;

import java.util.Scanner;

public class Input {

    public static void main(String[] args) {

//        String s = "sdaw dawaw";
        String newS = new String("sdaw dawaw");

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите что-нибудь..");
//
//        String string = scanner.nextLine();
//        System.out.println("Вы ввели '" + string + "'");


        System.out.println("Введите какое-нибудь число..");

        int nextInt = scanner.nextInt();
        System.out.println("Вы ввели '" + nextInt + "'");
    }
}
