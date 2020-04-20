package lesson_30_32__casting;

/**
 * Преобразование типов
 */
public class Casting {

    public static void main(String[] args) {

        float f = 123.2F;
        int i = 123;

        long l = i;        // Неявное
        double d = i;

        int x = (int) l;   // Явное

        System.out.println(l);

        byte b = (byte) 129;

        System.out.println(b);

        Dog dog = new Dog();

        // UpCasting -   восходящее преобразование
        Animal dogAnimal = new Dog();   // от наследника к родителю

        // DownCasting - нисходящее преобразование
        Dog animalDog = (Dog) new Animal();

        animalDog.bark();   // Animal cannot be cast to Dog
    }
}
