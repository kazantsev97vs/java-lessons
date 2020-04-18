package lesson_19__classes_and_objects___this;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Human human = new Human();
        human.setAge(18);
        human.setName("Tom");
        human.getInfo();
    }
}

class Human {
    // У класса мб
    // 1. Данные (поля)
    // 2. Действия, которые он может совершать (методы)

    private String name;
    private int age;

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