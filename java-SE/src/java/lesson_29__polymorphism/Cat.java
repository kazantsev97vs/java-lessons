package lesson_29__polymorphism;

public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("Cat is eating..");
    }

    public void meow() {
        System.out.println("meow!");
    }
}
