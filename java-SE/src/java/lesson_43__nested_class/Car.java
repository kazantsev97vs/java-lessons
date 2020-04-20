package lesson_43__nested_class;

public class Car {

    private int id;
    private static String name = "Car";

    public Car(int id) {
        this.id = id;
    }

    public void start() {
        Motor motor = new Motor();
        motor.setName("Rocket");
        motor.startMotor();


        System.out.println("Car " + id + " is starting...");
        int x = 10;

        class StartClass {
            public void start() {
                motor.startMotor();
                System.out.println("Motor \"" + motor.getName() + "\" was started in Car with id: " + id + "...");
                System.out.println(x);
            }
        }

        StartClass startClass = new StartClass();
        startClass.start();

    }


    /**
     * Вложенный нестатический класс
     */
    private class Motor {

        private String name;

        public void startMotor() {
            System.out.println("Motor " + id + " is starting...");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Вложенный статический класс
     * Не имеет доступа к нестатическийм полям Car (только к статическим)
     */
    public static class Battery {

        public void charge () {
            System.out.println(name + "Battery is charging...");
        }
    }

}
