package lesson_35__anonymous_class;

/**
 * Анонимные классы
 */
public class AnonymousClass {

    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.eat();

        OtherAnimal otherAnimal = new OtherAnimal();
        otherAnimal.eat();

        /**
         * Создание анонимного класса через класс
         * Объект, который здесь создается - не Animal! - это наследник класса Animal
         */
        Animal animal1 = new Animal() {
            @Override
            public void eat() {
                System.out.println("Override! Animal is eating..");
            }
        };

        /**
         * Создание анонимного класса через интерфейс
         */
        AbleToEat ableToEat = new AbleToEat() {
            @Override
            public void eat() {
                System.out.println("Override! AbleToEat is eating..");
            }
        };

        ableToEat.eat();
    }
}

interface AbleToEat {
    public void eat();
}

class Animal implements AbleToEat {

    @Override
    public void eat() {
        System.out.println("Animal is eating..");
    }
}

class OtherAnimal extends Animal {
    @Override
    public void eat() {
        System.out.println("Other Animal is eating..");
    }
}