package lesson_47__serialization___transient_serialVersionUID;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {

    public static void main(String[] args) {

        String path = "src/java/lesson_47__serialization___transient_serialVersionUID/people.bin";
        Person person = new Person(1, "Bob");

//        try {
//
//            // Обычно когда записывают бинарные данные в файл - создают файл с расширением .bin
//            // Записывает последовательность байтов в файл
//            FileOutputStream fileOutputStream = new FileOutputStream(path);
//
//            // Для записи объектов нужно преобразовать их в последовательность байтов и потом уже записать её в файл
//            // Записывает объекты в файл
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//            objectOutputStream.writeObject(person);
//
//            objectOutputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /**
         * try with resources - закрытие потоков автоматически
         * objectInputStream.close(); - не нужно
         */
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {

            objectOutputStream.writeObject(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
