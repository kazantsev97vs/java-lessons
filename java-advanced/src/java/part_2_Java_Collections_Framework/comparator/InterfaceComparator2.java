package java.part_2_Java_Collections_Framework.comparator;

import java.util.*;

public class InterfaceComparator2 {

    public static void main(String[] args) {

        List<String> peopleList = new ArrayList<>();
        Set<Person> personSet = new TreeSet<>();

        addElements(peopleList);
        addElements(personSet);

        Collections.sort(peopleList);

        System.out.println(peopleList);
        System.out.println(personSet);
    }

    private static void addElements(Collection collection) {

        collection.add(new Person(3, "Katy"));
        collection.add(new Person(1, "Bob"));
        collection.add(new Person(4, "George"));
        collection.add(new Person(2, "Tom"));

    }
}

class Person implements Comparable<Person> {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {

        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }
    }
}
