package lesson_38__exceptions___throw;

import java.util.Scanner;

public class Exceptions {

    public static void main(String[] args) throws ScannerException {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int x = Integer.parseInt(scanner.nextLine());

            if (x != 0) {
                throw new ScannerException("Пользователь ввел что-то кроме нуля");
            }
        }
    }
}
