package lesson_11__arrays;

public class Arrays {

    public static void main(String[] args) {

        // примитивные типы данных
        int number = 10;  // [10]
        char character = 'a';

        // ссылочные
        String s = "hello";
        String newS = new String("hello");

        int[] numbers = new int[5]; // numbers -> [массив]
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }
        for (int n :
                numbers) {
            System.out.print(n + " ");
        }

        System.out.println();

        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        for (int n :
                ints) {
            System.out.print(n + " ");
        }
    }
}
