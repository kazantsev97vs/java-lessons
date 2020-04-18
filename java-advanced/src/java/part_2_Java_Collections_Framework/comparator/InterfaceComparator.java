package java.part_2_Java_Collections_Framework.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterfaceComparator {

    public static void main(String[] args) {

        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("frog");
        animals.add("dog");
        animals.add("bird");
        animals.add("tiger");
        animals.add("c");
        animals.add("a");

        System.out.println(animals);
        Collections.sort(animals);
        System.out.println(animals);
        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        System.out.println(numbers);
        Collections.sort(numbers);
        System.out.println(numbers);
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(numbers);
    }
}

class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        /*
            o1 >  o2 => 1;
            o1 <  o2 => -1;
            o1 == o2 => 0;

            compare(2,1) => 1;
            compare(1,2) => -1;
            compare(1,1) => 0;
         */

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }

        // или
        // return Integer.compare(o1.length(), o2.length());
    }
}
