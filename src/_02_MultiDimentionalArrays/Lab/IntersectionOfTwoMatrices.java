package _02_MultiDimentionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] firstMatrix = readCharMatrix(sc, rows, cols);
        char[][] secondMatrix = readCharMatrix(sc, rows, cols);

        char[][] output = new char[rows][cols];

        for (int rol = 0; rol < rows; rol++) {
            for (int col = 0; col < cols; col++) {
                char firstElement = firstMatrix[rol][col];
                char secondElement = secondMatrix[rol][col];

                char fillChar = firstElement == secondElement ? firstElement : '*';
                output[rol][col] = fillChar;
            }
        }
        for (char[] chars : output) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readCharMatrix(Scanner sc, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] arr = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
            matrix[i] = arr;
        }

        return matrix;
    }
}
