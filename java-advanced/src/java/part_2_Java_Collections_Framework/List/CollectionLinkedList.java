package java.part_2_Java_Collections_Framework.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализует функционал динамического массива,
 *      т.е. массива, который расширяется при добавлении новых объектов.
 */
public class CollectionLinkedList {

    public static void main(String[] args) {

        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);
    }

    private static void measureTime(List<Integer> list) {

        for (int i = 0; i < 100_000; i++) {
            // добавление в конец списка
            list.add(i);                        // linkedList time: 131, arrayList time: 51
        }
//
//        for (int i = 0; i < 100_000; i++) {
//            // добавление в начало списка
//            list.add(0, i);                        // linkedList time: 9, arrayList time: 711
//        }
//
//        for (int i = 0; i < 100_000; i++) {
//            list.get(i);                        // linkedList time: 3464, arrayList time: 4
//        }
//
//        for (int i = 99_000; i >= 0; i--) {
//            // удаление c конца списка
//            list.remove(i);                        // linkedList time: 131, arrayList time: 14
//        }

        long start = System.currentTimeMillis();

        for (int i = 99_000; i >= 0; i--) {
            // удаление c начала списка
            list.remove(0);                        // linkedList time: 4, arrayList time: 737
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
