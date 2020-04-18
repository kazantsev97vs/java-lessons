package java.part_2_Java_Collections_Framework.Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * interface Iterable
 *      - это то, по чему можно итерироваться|проходиться
 *
 * iterator() - возвращает объект класса Iterator<>,
 *              котороый позволяет проходиться по элементам нашей коллекции.
 *
 *              hasNext()
 *              next()
 *              remove()
 *
 */
public class InterfaceIterable {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Iterator хранит в себе указатель на элемент объекта
        // Когда первый раз получаем итератор - указатель указывает на место до первого объекта
        // Когда вызываем next() итератор перемещается на первый элемент
        // (каждый раз перемещается на один элемент вправо)
        Iterator<Integer> iterator = list.iterator();

        int idx = 0;

        // Before Java 5
        // Можно изменить спискок, пока мы по нему проходимся
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            if (idx == 1) {
                iterator.remove();
            }

            idx++;
        }

        // Java 5
        // Нельзя изменить спискок, пока мы по нему проходимся
        for (int x :
                list) {
            System.out.println(x);
        }

        System.out.println(list);
    }
}
