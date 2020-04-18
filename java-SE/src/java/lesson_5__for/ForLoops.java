package lesson_5__for;

public class ForLoops {

    public static void main(String[] args) {

        int value = 0;

        for (
                int i = 0;  // блок инициализации переменной счетчика
                i <= 10;    // блок условия - цикл выполняется пока условие верно
                i++         // блок измененния переменной счетчика
        ) {
            System.out.println(i);
        }
    }
}
