package lesson_44__file_writing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriting {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/java/lesson_44__file_writing/file.txt");

        PrintWriter writer = new PrintWriter(file);

        System.out.println();
        writer.println("Test row 1");
        writer.println("Test row 2");

        writer.close();

    }
}
