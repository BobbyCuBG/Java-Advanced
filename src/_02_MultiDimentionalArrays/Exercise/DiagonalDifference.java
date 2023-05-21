package _02_MultiDimentionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(sc, size, matrix);

        int firstSum = getSumPrimaryDiagonal(matrix, size);
        int secondSum = getSumSecondaryDiagonal(matrix, size);

        System.out.println(Math.max(firstSum, secondSum) - Math.min(firstSum, secondSum));
    }

    private static int getSumPrimaryDiagonal(int[][] matrix, int size) {
        int sum = 0;

        int row = 0;
        int col = 0;

        while (row < size) {
            sum += matrix[row][col];
            row++;
            col++;
        }
        return sum;
    }

    private static int getSumSecondaryDiagonal(int[][] matrix, int size) {
        int sum = 0;

        for (int row = size - 1; row >= 0; row--) {
            for (int col = 0; col < size; col++) {
                sum+= matrix[row][col];
                row--;
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner sc, int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            int[] arr = fillArr(sc);
            matrix[row] = arr;
        }
    }

    private static int[] fillArr(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
