package lesson_26__interfaces;

public class Animal implements Info {

    private int id;

    public Animal(int id) {
        this.id = id;
    }

    public void sleep() {
        System.out.println("I am sleeping..");
    }

    // Реализуем метод интерфейса Info
    @Override
    public void showInfo() {
        System.out.println("ID is " + this.id);
    }
}
