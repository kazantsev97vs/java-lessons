package lesson_20__classes_and_objects___constructor;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Human human1 = new Human();
        human1.getInfo();

        Human human2 = new Human("VASYA");
        human2.getInfo();

        Human human3 = new Human("VASYA", 19);
        human3.getInfo();

    }
}

class Human {

    private String name;
    private int age;

    Human() {
        System.out.println("1 constructor");
    }

    Human(String name) {
        System.out.println("2 constructor");
        this.name = name;
    }

    Human(String name, int age) {
        System.out.println("3 constructor");
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getInfo() {
        System.out.println(name + ", " + age);
    }
}