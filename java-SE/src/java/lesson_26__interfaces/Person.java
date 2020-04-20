package lesson_26__interfaces;

public class Person implements Info {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    // Реализуем метод интерфейса Info
    @Override
    public void showInfo() {
        System.out.println("Name is " + this.name);
    }
}
