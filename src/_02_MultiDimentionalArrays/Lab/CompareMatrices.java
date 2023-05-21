package _02_MultiDimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(sc);
        int[][] secondMatrix = readMatrix(sc);

        boolean areEqual = compareMatrix(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatrix(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return  false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];

            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                int firstMatrixElement = firstArr[col];
                int secondMatrixElement = secondArr[col];

                if (firstMatrixElement != secondMatrixElement) {
                    return false;
                }
            }
        }
        return true;
    }


    private static int[] fillElements(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static int[][] readMatrix(Scanner sc) {
        String[] dimensions = sc.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = fillElements(sc);
            matrix[i] = arr;
        }

        return matrix;
    }
}
