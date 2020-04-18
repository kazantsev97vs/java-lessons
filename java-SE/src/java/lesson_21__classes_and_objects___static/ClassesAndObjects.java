package lesson_21__classes_and_objects___static;

public class ClassesAndObjects {

    public static void main(String[] args) {

        Human.description = "nice";
//        Human.getDescription();

        Human human3 = new Human("VASYA", 19);
        human3.description = "bad";
        human3  .getDescription();
        human3.setName("Tom");
        human3.getInfo();

    }
}

class Human {
    private String name;
    private int age;
    public static String description;

    static {
    }

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

    public void getDescription() {
        System.out.println(description);
    }
}