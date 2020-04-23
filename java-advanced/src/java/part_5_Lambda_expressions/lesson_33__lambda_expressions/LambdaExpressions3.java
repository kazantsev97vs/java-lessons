package part_5_Lambda_expressions.lesson_33__lambda_expressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaExpressions3 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("hello");
        list.add("goodbye");
        list.add("a");
        list.add("ab");

        System.out.println(list);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(list);

        list.sort((String o1, String o2) -> {
            if (o1.length() > o2.length()) return -1;
            else if (o1.length() < o2.length()) return 1;
            else return 0;
        });

        System.out.println(list);

        Comparator<String> comparator = (String o1, String o2) -> {
            if (o1.length() > o2.length()) return 1;
            else if (o1.length() < o2.length()) return -1;
            else return 0;
        };

        list.sort(comparator);

        System.out.println(list);
    }
}


