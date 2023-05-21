package _02_MultiDimentionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            aPatternFillMatrix(matrix, size);
        } else if (pattern.equals("B")) {
            bPatternFillMatrix(matrix, size);
        }
        Arrays.stream(matrix)
                .forEach(e -> {
                    for (int i : e) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                });
    }

    private static void aPatternFillMatrix(int[][] matrix, int size) {
        int digit = 1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                while (row < size) {
                    matrix[row][col] = digit;
                    digit++;
                    row++;
                }
                if (col == size - 1) {
                    return;
                }
                row = 0;
            }
        }
    }

    private static void bPatternFillMatrix(int[][] matrix, int size) {
        int digit = 1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                while (row < size) {
                    matrix[row][col] = digit;
                    digit++;
                    row++;
                }
                if (col == size - 1) {
                    return;
                }
                row--;
                col++;
                while (row >= 0) {
                    matrix[row][col] = digit;
                    digit++;
                    row--;
                }
                if (col == size - 1) {
                    return;
                }
                row = 0;
            }
        }
    }
}
