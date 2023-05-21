package _02_MultiDimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = readMatrix(sc);
        int[][] maxMatrix = new int[2][2];
        int maxSum = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length - 1; col++) {
                int sum = matrix[row][col]
                        + matrix[row][col + 1]
                        + matrix[row + 1][col]
                        + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix = new int[][] {
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(maxSum);
    }
    private static void printMatrix (int[][] matrix) {
        for (int[] num : matrix) {
            for (int i : num) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
    private static int[][] readMatrix(Scanner sc) {
        int[] dimensions = fillArr(sc);

        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int row = 0; row < dimensions[0]; row++) {
            int[] arr = fillArr(sc);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] fillArr(Scanner sc) {
        return Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
