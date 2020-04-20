package lesson_29__polymorphism;

public class Dog extends Animal {

    public void bark () {
        System.out.println("Animal is barking..");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating..");
    }
}
