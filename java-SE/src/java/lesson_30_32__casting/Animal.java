package lesson_30_32__casting;

public class Animal {

    private Integer id;

    public Animal() {
    }

    public Animal(Integer id) {
        this.id = id;
    }

    public void eat() {
        System.out.println("Animal is eating");
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
