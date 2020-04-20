package lesson_25__inheritance;

/**
 * Собака расширяет класс Животное
 */
public class Dog extends Animal {

    public void bark() {
        System.out.println("bark!");
    }

    // Переопределяем методы родителя
    @Override
    public void eat() {
        bark();
        System.out.println("Dog is eating...");
        bark();
    }

    @Override
    public String toString() {
        return "Dog{}";
    }

    public String showName() {
        return getName() + " Dog";
        // return name;        // Error 'name' has private access in 'Animal'
    }
}
