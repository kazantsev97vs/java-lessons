package lesson_49__recursion;

/**
 * Рекурсией называется вызов метода в теле этого же метода.
 */
public class Recursion {

    public static void main(String[] args) {

        // someMethod();    // Hello!! Hello!! Hello!! Hello!! ... Hello!! -> StackOverflowError

        // counter(3);      // 3 2 1

        // factorial 4: 4! = 4 * 3 * 2 * 1
        // 0! = 1 - соглашение

        System.out.println(factorial(4));   // 4 * 3 * 2 * 1 = 24
        System.out.println(factorial(0));   // 1
    }

    // someMethod() -> someMethod() -> someMethod() -> ... -> someMethod() -> StackOverflowError
    // чтобы бесконечного вызова метода и переполнения стэка не произошло
    // нам нужен т.н. Base case (Базовый случай)
    // - условие при котором мы перестаем вызывать метод и возвращаемся из этого метода
    private static void someMethod() {
        System.out.println("Hello!!");
        someMethod();
    }

    // 1 counter(3)                                                                   -> counter(3) return;
    // 2              -> counter(2)                           -> counter(2) return;
    // 3                              -> counter(1) return;

    private static void counter(int n) {
        System.out.println(n);

        if (n == 1) return;

        counter(n - 1); // 3, 2, 1
    }

    // factorial(4)
    // - сначала слева вниз потом справа наверх:
    //
    // 4 * factorial(3)        return 4 * 6 = 24
    // 3 * factorial(2)        return 3 * 2 = 6
    // 2 * factorial(1)        return 2 * 1 = 1
    // factorial(1)            return 1

    private static int factorial(int n) {

        if (n == 1 || n == 0) return 1;

        return n * factorial(n - 1);
    }
}
