package java.part_2_Java_Collections_Framework.Set;

import java.util.*;

/**
 * Тоже самое что и в случае с Map,
 * только Map хранил в себе пары (ключ, значение),
 * а объекты класса Set хранят в себе обычные Объекты,
 * также как List.
 * Set похож на List - они хранят в себе одиночные элементы,
 * только в Set-e нельзя хранить одинаковые элементы
 */
public class CollectionSet {

    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>(); // не сохраняет порядка, как и HashMap

        // тоже самое, что и в LinkedHashMap
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохранятеся порядок ввода
        // в каком порядке элементы были добавлены, в таком порядке они и вернутся

        // (естественный порядок)
        Set<String> treeSet = new TreeSet<>();


//        System.out.println("HashSet");
//        testSet(hashSet);

        // contains - работает за константное время
//        System.out.println(hashSet.contains("Mike"));
//        System.out.println(hashSet.contains("mike"));
//        System.out.println(hashSet.isEmpty());

//        System.out.println();
//        System.out.println("LinkedHashSet");
//        testSet(linkedHashSet);
//        System.out.println();
//        System.out.println("TreeSet");
//        testSet(treeSet);

        Set<Integer> integerSet1 = new HashSet<>();
        for (int i = 0; i <= 10; i++) {
            integerSet1.add(i);
        }
        System.out.println(integerSet1);

        Set<Integer> integerSet2 = new HashSet<>();
        for (int i = 5; i <= 15; i++) {
            integerSet2.add(i);
        }
        System.out.println(integerSet2);

        /**
         * union - объекдинение множеств
         */
        Set<Integer> union = new HashSet<>(integerSet1);
        union.addAll(integerSet2);
        System.out.println("union:" + union);

        /**
         * intersection - пересечение множеств
         */
        Set<Integer> intersection = new HashSet<>(integerSet1);
        intersection.retainAll(integerSet2);
        System.out.println("intersection:" + intersection);

        /**
         * subtract - разность множеств
         */
        Set<Integer> integerSet1SubtractIntegerSet2 = new HashSet<>(integerSet1);
        integerSet1SubtractIntegerSet2.removeAll(integerSet2);
        System.out.println("integerSet1SubtractIntegerSet2:" + integerSet1SubtractIntegerSet2);

        /**
         * exclusiveOr - симметрическая разность множеств
         */
        Set<Integer> exclusiveOr = new HashSet<>(integerSet1);
        exclusiveOr.addAll(integerSet2);
        exclusiveOr.removeAll(intersection);
        System.out.println("exclusiveOr:" + exclusiveOr);
    }

    public static void testSet(Set<String> set) {

        set.add("Mike");
        set.add("Make");
        set.add("Katy");
        set.add("Tom");
        set.add("Tom");
        set.add("Adam");
        set.add("George");
        set.add("Donald");
        set.add("Volodya");

//        for (String name :
//                set) {
//            System.out.println(name);
//        }

        System.out.println(set);
    }
}
