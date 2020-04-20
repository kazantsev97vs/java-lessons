package lesson_33__Generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        /** ------------ JAVA 5 ------------ */
        List list = new ArrayList();
        list.add("awd");
        list.add(1);

        String awd = (String) list.get(0); // Object
        System.out.println(list);

        /** ----- С появлением Generics ---- */
        List<String> stringList = new ArrayList<String>();
        stringList.add("awd");
        stringList.add("add");
        // stringList.add(1);      // error

        String add = stringList.get(1);
        System.out.println(add);

        /** ------------ JAVA 7 ------------ */
        List<String> stringList7 = new ArrayList<>();
    }
}
