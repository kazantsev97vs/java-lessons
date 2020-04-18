package java.part_2_Java_Collections_Framework.hashcode_equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashcodeAndEquals {

    public static void main(String[] args) {

//        Map<Integer, String> map = new HashMap<>();
//        Set<Integer> set = new HashSet<>();
//
//        map.put(1, "One");
//        map.put(1, "NotOne");
//
//        set.add(1);
//        set.add(1);
//
//        System.out.println();
//        System.out.println(map);
//        System.out.println(set);
//
//        boolean b = 1 == 2;

        Person person1 = new Person(1, "Mike");
        Person person2 = new Person(1, "Mike");

        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        map.put(person1, "123");
        map.put(person2, "123456");

        set.add(person1);
        set.add(person2);

        System.out.println();
        System.out.println(map);
        System.out.println(set);

        Set<String> stringSet = new HashSet<>();
        stringSet.add("Hello");
        stringSet.add("Hello");
        System.out.println();
        System.out.println(stringSet);

        Integer one = 1;
        System.out.println("hashCode (1) = " + one.hashCode());
        System.out.println("equals (1) = " + one.equals(1));

        System.out.println();
        String s = "awddawfaf";
        System.out.println(s.equals("awddawfaf"));
        System.out.println(s.hashCode());
    }
}


class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (id != person.id) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person {"
                + "id = " + id + ", "
                + "name = " + name
                + "}";
    }


}
