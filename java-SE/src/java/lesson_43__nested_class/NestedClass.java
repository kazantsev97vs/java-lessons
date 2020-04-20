package lesson_43__nested_class;

public class NestedClass {

    public static void main(String[] args) {

        Car car = new Car(1);
        car.start();

        Car.Battery battery = new Car.Battery();

    }
}
