package lesson_46__serialization___arrays;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ReadObject {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("src/java/lesson_46__serialization___arrays/people.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

//            /**
//             * 1 вариант записи массива в файл
//             */
//            int personCount = objectInputStream.readInt();
//            Person[] people = new Person[personCount];
//
//            for (int i = 0; i < personCount; i++) {
//                people[i] = (Person) objectInputStream.readObject();
//            }
//

            /**
             * 2 вариант записи массива в файл
             * т.к. массив - это тоже объект, запишем целиком массив в файл, как объект
             */
            Person[] people = (Person[]) objectInputStream.readObject();

            System.out.println(Arrays.toString(people));

            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
