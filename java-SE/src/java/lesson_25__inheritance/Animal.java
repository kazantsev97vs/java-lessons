package lesson_25__inheritance;

public class Animal {

    private String name = "Some animal";

    public void eat() {
        System.out.println("I am eating...");
    }

    public void sleep() {
        System.out.println("I am sleeping...");
    }

    public String getName() {
        return name;
    }
}
