package _02_MultiDimentionalArrays.Lab;


import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split(", ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = readMatrix(sc, rows, cols);
        int sum = calculateSum(matrix, rows, cols);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }

    private static int calculateSum(int[][] matrix, int rows, int cols) {
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row <rows; row++) {
            int[] arr = Arrays.stream(sc.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
    /*      3, 6
            7, 1, 3, 3, 2, 1
            1, 3, 9, 8, 5, 6
            4, 6, 7, 9, 1, 0   */
}
