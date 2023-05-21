package _02_MultiDimentionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = fillMatrix(sc, range[0], range[1]);

        String input = sc.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");

            if (isValidCommandAndInRange(tokens, range)) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                swap(row1, col1, row2, col2, matrix);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }


            input = sc.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        Arrays.stream(matrix).forEach(row -> {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        });
    }

    private static void swap(int row1, int col1, int row2, int col2, String[][] matrix) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
    }

    private static String[][] fillMatrix(Scanner sc, int row, int col) {
        String[][] matrix = new String[row][col];

        for (int r = 0; r < row; r++) {
            String[] arr = sc.nextLine().split("\\s+");
            matrix[r] = arr;
        }
        return matrix;
    }

    private static boolean isValidCommandAndInRange(String[] tokens, int[] range) {
        return tokens.length == 5 && tokens[0].equals("swap") && inRange(tokens, range[0], range[1]);
    }

    private static boolean inRange(String[] tokens, int row, int col) {
        int row1 = Integer.parseInt(tokens[1]);
        int col1 = Integer.parseInt(tokens[2]);
        int row2 = Integer.parseInt(tokens[3]);
        int col2 = Integer.parseInt(tokens[4]);

        return row1 >= 0 && row1 <= col && row2 >= 0 && row2 <= col && col1 >= 0 && col1 <= row && col2 >= 0 && col2 <= row;
    }
}
