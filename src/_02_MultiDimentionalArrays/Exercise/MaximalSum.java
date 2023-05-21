package _02_MultiDimentionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] matrix = fillMatrix(sc, range[0], range[1]);

        int maxSum = 0;
        int[][] matrix3x3 = new int[3][3];

        int rowLimit = range[0] - 2;
        int colLimit = range[1] - 2;
        for (int row = 0; row < rowLimit; row++) {
            for (int col = 0; col < colLimit; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row][col + 2]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1]
                        + matrix[row + 1][col + 2]
                        + matrix[row + 2][col]
                        + matrix[row + 2][col + 1]
                        + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    matrix3x3 = new int[][] {
                            {matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]},
                            {matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]}
                    };
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printFinalMatrix(matrix3x3);
    }

    private static void printFinalMatrix(int[][] matrix3x3) {
        Arrays.stream(matrix3x3).forEach(r -> {
            for (int col : r) {
                System.out.print(col + " ");
            }
            System.out.println();
        });
    }

    private static int[][] fillMatrix(Scanner sc, int row, int col) {
        int[][] matrix = new int[row][col];

        for (int r = 0; r < row; r++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = arr;
        }
        return matrix;
    }
}
