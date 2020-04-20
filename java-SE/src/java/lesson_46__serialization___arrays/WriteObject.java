package lesson_46__serialization___arrays;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static void main(String[] args) {

        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Mike");
        Person[] people = new Person[4];
        people[0] = person1;
        people[1] = person2;
        people[2] = new Person(3, "Tom");
        people[3] = new Person(4, "Bred");

        try {

            // Обычно когда записывают бинарные данные в файл - создают файл с расширением .bin
            // Записывает последовательность байтов в файл
            FileOutputStream fileOutputStream = new FileOutputStream("src/java/lesson_46__serialization___arrays/people.bin");

            // Для записи объектов нужно преобразовать их в последовательность байтов и потом уже записать её в файл
            // Записывает объекты в файл
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

//            /**
//             * 1 вариант записи массива в файл
//             */
//            // Запишем в файл сначала длину массива
//            objectOutputStream.writeInt(people.length);
//
//            // Теперь запишем объекты
//            for (Person person : people) {
//                objectOutputStream.writeObject(person);
//            }

            /**
             * 2 вариант записи массива в файл
             * т.к. массив - это тоже объект, запишем целиком массив в файл, как объект
             */
            objectOutputStream.writeObject(people);

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
