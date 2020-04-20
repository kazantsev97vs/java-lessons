package lesson_36__file_reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FileReading {

    public static void main(String[] args) {

        /**
         * System.in - константа, находится в классе System, System находится в пакете Java Lang
         * in - в этой константе находится стандартный поток ввода
         */
        Scanner scanner = new Scanner(System.in);

        // File.separator - для каждой операционной системы свой
        // В separator поместится тот разделитель, который в системе
        String separator = File.separator;

        String absolutePath = "C:" + separator + "Users" + separator + "kvs" + separator + "Desktop" + separator +
                "java" + separator + "java-lessons" + separator + "java-SE" + separator + "src" + separator +
                "java" + separator + "lesson_36__file_reading" + separator + "file.txt";

        String contentRootPath = "src" + separator + "java" + separator + "lesson_36__file_reading" + separator + "file.txt";

        File file = new File(absolutePath);

        try {

            Scanner fileScanner = new Scanner(file);
            StringBuilder fileText = new StringBuilder();

            while (fileScanner.hasNext()) {
                fileText.append(fileScanner.nextLine()); // .append("\n")
            }

            System.out.println(fileText);

            String[] numbers = fileText.toString().split(" ");
            int[] ints = new int[3];
            int counter = 0;

            for (String s :
                    numbers) {
                ints[counter++] = Integer.parseInt(s);
            }

            System.out.println(Arrays.toString(ints));

            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
