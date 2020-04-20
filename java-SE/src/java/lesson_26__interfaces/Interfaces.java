package lesson_26__interfaces;

/**
 * Интерфейсы
 *  если класс реализует какой-то интерфейс - это значит,
 *  что он обязан иметь методы, которые в этом интерфейсе указаны
 */
public class Interfaces {

    public static void main(String[] args) {

        Animal animal = new Animal(1);
        animal.showInfo();
        animal.sleep();

        System.out.println();

        Person person = new Person("Bob");
        person.showInfo();
        person.sayHello();

        System.out.println();

        // Сужаем все методы и поля классов "Animal" и "Person" до методов и полей, объявленных в интерфейсе "Info"
        // мы рассматриваем класс Animal не как класс Animal, а как нечто, что реализует интерфейс Info
        Info info1 = new Animal(2);
        Info info2 = new Person("Bob2");

        info1.showInfo();
        // info1.sleep(); Info ничего не знает про метод sleep() класса Animal
        info2.showInfo();

        System.out.println();

        outputInfo(animal);
        outputInfo(person);
        outputInfo(info1);
        outputInfo(info2);
    }

    public static void outputInfo(Info infoInterfaceImplementing) {
        infoInterfaceImplementing.showInfo();
    }
}