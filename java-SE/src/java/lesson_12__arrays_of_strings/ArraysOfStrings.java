package lesson_12__arrays_of_strings;

public class ArraysOfStrings {

    public static void main(String[] args) {

        int[] ints = new int[5];
        ints[0] = 10;

        System.out.println(ints[0]);
        System.out.println(ints[1]);

        String[] strings = new String[3];
        strings[0] = "Привет";
        strings[1] = "пока";
        strings[2] = "джава";

        for (String s :
                strings) {
            System.out.println(s);
        }

        int[] ints1 = {1, 2, 3, 4};
        int sum = 0;

        for (int x :
                ints1) {
            sum += x;
        }
        System.out.println();
        System.out.println(sum);

        int value = 0;
        String s = null;
        System.out.println(s);
    }
}
