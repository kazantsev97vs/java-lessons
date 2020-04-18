package lesson_6__if;

public class If {

    public static void main(String[] args) {

        if (5 == 5) {
            System.out.println("Да, верно");
        }

        if (5 != 5 == false) {
            System.out.println("Нет, неверно");
        }

        int myInt = 11;

        if (myInt < 10) {
            System.out.println(myInt + " < 10");

        } else if (myInt > 10) {
            System.out.println(myInt + " > 10");

        } else {
            System.out.println("10 == " + myInt);
        }

    }
}
