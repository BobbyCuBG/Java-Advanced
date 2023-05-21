package _02_MultiDimentionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[rows][];
        fillMatrix(rows, matrix, sc);

        int[] wrongNumberIndex = readArray(sc);
        int wrongNumber = matrix[wrongNumberIndex[0]][wrongNumberIndex[1]];

        int[][] newMatrix = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new int[matrix[i].length];
            System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);
        }
        for (int row = 0; row < rows; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    int newNumberToReplace = calculateNumber(row, col, matrix, wrongNumber);
                    newMatrix[row][col] = newNumberToReplace;
                }
            }
        }
        for (int[] r : newMatrix) {
            for (int c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static int calculateNumber(int row, int col, int[][] matrix, int wrongNumber) {
        int leftNumber = leftNumber(row, col, matrix, wrongNumber);
        int rightNumber = rightNumber(row, col, matrix, wrongNumber);
        int topNumber = topNumber(row, col, matrix, wrongNumber);
        int bottomNumber = bottomNumber(row, col, matrix, wrongNumber);
        return  leftNumber + rightNumber + topNumber + bottomNumber;
    }

    private static int leftNumber(int row, int col, int[][] matrix, int wrongNumber) {
        return col - 1 >= 0 && matrix[row][col - 1] != wrongNumber ? matrix[row][col - 1] : 0;
    }

    private static int rightNumber(int row, int col, int[][] matrix, int wrongNumber) {
        return col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber ? matrix[row][col + 1] : 0;
    }

    private static int topNumber(int row, int col, int[][] matrix, int wrongNumber) {
        return row - 1 >= 0 && matrix[row - 1][col] != wrongNumber ? matrix[row - 1][col] : 0;
    }

    private static int bottomNumber(int row, int col, int[][] matrix, int wrongNumber) {
        return row + 1 < matrix[col].length && matrix[row + 1][col] != wrongNumber ? matrix[row + 1][col] : 0;
    }

    private static void fillMatrix(int rows, int[][] matrix, Scanner sc) {
        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(sc);

            matrix[row] = arr;
        }
    }

    private static int[] readArray(Scanner sc) {
        return Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
