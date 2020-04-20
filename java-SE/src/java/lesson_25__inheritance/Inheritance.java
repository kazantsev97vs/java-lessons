package lesson_25__inheritance;

/**
 * Наследование
 */
public class Inheritance {

    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println(animal.getName());
        animal.eat();
        animal.sleep();

        System.out.println();

        Dog dog = new Dog();
        System.out.println(dog.showName());
        dog.eat();
        dog.sleep();
        dog.bark();
    }
}
