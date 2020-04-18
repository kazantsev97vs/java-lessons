package lesson_14__classes_and_objects;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Person person = new Person();
        person.name = "Roman";
        person.age = 50;

        System.out.println(
                "My name is " + person.name + ",\n"
                + "My age is " + person.age
        );

        Person person2 = new Person();
        person2.name = "VoVa";
        person2.age = 20;

        System.out.println(
                "My name is " + person2.name + ",\n"
                        + "My age is " + person2.age
        );
    }
}

class Person {
    // У класса мб
    // 1. Данные (поля)
    // 2. Действия, которые он может совершать (методы)

    String name;
    int age;
}