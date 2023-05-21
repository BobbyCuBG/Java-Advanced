package _02_MultiDimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[size][size];

        fillMatrix(sc, matrix, size);
        printFirstDiagonal(matrix, size);
        printSecondDiagonal(matrix, size);

    }

    private static void fillMatrix(Scanner sc, int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }
    }

    private static void printFirstDiagonal(int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
                row++;
            }
            System.out.println();
        }
    }

    private static void printSecondDiagonal(int[][] matrix, int size) {
        int row = size - 1;
        int col = 0;

        while (isInBound(row, col, matrix)) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static boolean isInBound(int row, int col, int[][] matrix) {
        return row >= 0 && row <= matrix.length && col >= 0 && col <= matrix[col].length;
    }
}
