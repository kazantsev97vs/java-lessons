package lesson_16__classes_and_objects;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Person person = new Person();
        person.name = "Roman";
        person.age = 50;
        int years1 = person.calculateYearsToRetirement();
        System.out.println("Первому человеку количество лет до пенсии: " + years1);

        Person person2 = new Person();
        person2.name = "VoVa";
        person2.age = 20;
        person2.calculateYearsToRetirement();
        int years2 = person2.calculateYearsToRetirement();
        System.out.println("Второму человеку количество лет до пенсии: " + years2);
    }
}

class Person {
    // У класса мб
    // 1. Данные (поля)
    // 2. Действия, которые он может совершать (методы)

    String name;
    int age;

    int calculateYearsToRetirement() {
        return 65 - age;
    }

    void speak() {
        for (int i = 0; i < 3; i++) {
            System.out.println("My name is " + name);
            System.out.println("My age is " + age);
        }
    }

    void sayHello() {
        System.out.println("Hello!");
    }
}