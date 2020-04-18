package lesson_13__multidimensional_array;

public class MultidimensionalArray {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        /*
            1,2,3,4,5,6,7

            1 2 3
            4 5 6
            7 8 9
         */

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
        System.out.println(matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
        System.out.println(matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);

        String[][] strings = new String[2][3];
        strings[0][1] = "hello";
        System.out.println(strings[0][1]);

        for (int i = 0; i < matrix.length; i++) {

            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "] ");
            }

            System.out.println("|");
        }


    }
}
