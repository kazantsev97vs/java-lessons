package lesson_40__exceptions;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 */
public class Exceptions {

    public static void main(String[] args) {

        try {
            run();

        } catch (IOException | ParseException e) {  // Multi catch
            e.printStackTrace();
        } catch (Exception e) {  // Multi catch
            e.printStackTrace();
        }
        // catch (IllegalArgumentException e) {
        // Родитель Exception отловит любые виды ошибок.
        // Блоки catch после него не имеют смысла - не будут использованы никогда
        // }
    }

    public static void run () throws IOException, ParseException, IllegalArgumentException {}
}
