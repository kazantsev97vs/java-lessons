package java.part_2_Java_Collections_Framework.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализует функционал динамического массива,
 *      т.е. массива, который расширяется при добавлении новых объектов.
 */
public class CollectionArrayList {

    public static void main(String[] args) {

        int[] x = new int[3];

//        for (int i = 0; i <= 3; i++) {  // java.lang.ArrayIndexOutOfBoundsException
//            x[i] = i;
//        }

        List<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            integerArrayList.add(i);
        }

        System.out.println(integerArrayList);
        System.out.println(integerArrayList.get(0));
        System.out.println(integerArrayList.get(3));
        System.out.println("size is " + integerArrayList.size());

        for (int i = 0; i <= 3; i++) {
            System.out.print(integerArrayList.get(i));
        }

        System.out.println();

        integerArrayList.remove(2);
        System.out.println(integerArrayList);
        System.out.println("size is " + integerArrayList.size());

        integerArrayList = new LinkedList<>(integerArrayList);

    }
}
