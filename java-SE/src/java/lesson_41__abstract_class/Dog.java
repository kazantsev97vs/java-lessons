package lesson_41__abstract_class;

public class Dog extends Animal implements AbleToSing {

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public void singASong() {
        System.out.println("Bark, Bark, Bark,\nBark,\nBaaaaaaaaaaaaaaaark");
    }
}
