package lesson_29__polymorphism;

/**
 * Полиморфизм
 *              - множество форм
 *              - способность метода обрабатывать данные разных типов
 *
 */
public class Polymorphism {

    public static void main(String[] args) {

        Animal animal = new Animal();

        Animal animalDog = new Dog();
        // Позднее связывание
        animalDog.eat();
        animalDog.sleep();
        // animalDog.bark(); - Animal ничего не знает про метод bark() объявленный и реализованный в классе Dog

        System.out.println();

        Dog dog = new Dog();
        dog.eat();
        dog.sleep();
        dog.bark();

        System.out.println();

        Cat cat = new Cat();
        cat.eat();
        cat.sleep();
        cat.meow();

        System.out.println();

        feedAnimal(animal);
        feedAnimal(animalDog);
        feedAnimal(dog);
        feedAnimal(cat);
    }

    public static void feedAnimal (Animal animal) {
        animal.eat();
    }
}
