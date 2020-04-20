package lesson_45__serialization___objects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static void main(String[] args) {

        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Mike");

        try {

            // Обычно когда записывают бинарные данные в файл - создают файл с расширением .bin
            // FileOutputStream записывает последовательность байтов в файл
            FileOutputStream fileOutputStream = new FileOutputStream("src/java/lesson_45__serialization___objects/people.bin");

            // Для записи объектов нужно преобразовать их в последовательность байтов и потом уже записать её в файл
            // ObjectOutputStream записывает объекты в последовательность байтов
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(person2);

            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
