package lesson_18__classes_and_objects;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Person person = new Person();
        person.setName("123");
        person.setAge(50);
        int years1 = person.calculateYearsToRetirement();
        System.out.println("Первому человеку количество лет до пенсии: " + years1);
        person.speak();


    }
}

class Person {
    // У класса мб
    // 1. Данные (поля)
    // 2. Действия, которые он может совершать (методы)

    private String name;
    private int age;

    int calculateYearsToRetirement() {
        return 65 - age;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Ты ввел пустое имя!");
        }

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
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