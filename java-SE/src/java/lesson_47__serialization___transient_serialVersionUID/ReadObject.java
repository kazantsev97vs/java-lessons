package lesson_47__serialization___transient_serialVersionUID;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {

    public static void main(String[] args) {

        String path = "src/java/lesson_47__serialization___transient_serialVersionUID/people.bin";

//        try {
//            FileInputStream fileInputStream = new FileInputStream(path);
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//            Person person = (Person) objectInputStream.readObject();
//            System.out.println(person);
//
//            objectInputStream.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        /**
         * try with resources - закрытие потоков автоматически
         * objectInputStream.close(); - не нужно
         */

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {

            Person person = (Person) objectInputStream.readObject();
            System.out.println(person);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
