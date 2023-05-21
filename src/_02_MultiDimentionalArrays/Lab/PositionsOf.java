package _02_MultiDimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] matrix = readMatrix(sc);
        int numberToLookFor = Integer.parseInt(sc.nextLine());

        findNumber(matrix, numberToLookFor);
    }

    private static void findNumber(int[][] matrix, int number) {
        boolean wasFound = false;
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = matrix[row];

            for (int col = 0; col < arr.length; col++) {
                if (number == arr[col]) {
                    System.out.println(row + " " + col);
                    wasFound = true;
                }
            }
        }
        if (!wasFound) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(Scanner sc) {
        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int [][] matrix = new int[dimensions[0]][dimensions[1]];
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;
        }

        return matrix;
    }
}
