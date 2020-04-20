package lesson_24__object_toString;

/**
 * Любой класс в JAVA наследуется от класса Object (заимствует все его методы и поля)
 * (они делают это скрыто - без extends)
 *
 * toString() по дефолту: getClass().getName() + "@" + Integer.toHexString(hashCode());
 * имя класса + @ + хешкод
 */
public class ObjectAndToString {

    public static void main(String[] args) {

        String hello = "hello";

        Human Bob = new Human("Bob", 22);

        // До переопределения метода toString() : lesson_24__object_toString.Human@1b6d3586
        // После переопределения метода toString() : Human{name='Bob', age=22}
        System.out.println(Bob.toString());

    }
}

class Human {

    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}