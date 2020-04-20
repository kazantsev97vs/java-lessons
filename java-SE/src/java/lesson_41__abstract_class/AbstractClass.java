package lesson_41__abstract_class;

public class AbstractClass {

    public static void main(String[] args) {

        // Animal animal = new Animal(); Error

        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.eat();
        cat.makeSound();

        dog.eat();
        dog.makeSound();
        dog.singASong();

    }
}