package lesson_34__wildcards_generics;

import lesson_30_32__casting.Animal;
import lesson_30_32__casting.Dog;

import java.util.ArrayList;
import java.util.List;

public class Wildcards_Generics {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal(1));
        animalList.add(new Animal(2));
        animalList.add(new Animal(3));

        test(animalList);

        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        dogList.add(new Dog());

        test(dogList);

//        Object object = new Object();
    }

    // <? extends Animal> - использовать Animal и всех его потомков
    // <? super Animal> - использовать всех родителей класса Animal
    private static void test(List<? extends Animal> list) {

        for (Animal animal : list) {
            System.out.println(animal);
            animal.eat();
        }
    }
}
