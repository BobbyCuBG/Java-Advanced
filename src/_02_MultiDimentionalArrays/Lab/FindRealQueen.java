package _02_MultiDimentionalArrays.Lab;

import java.util.Scanner;

public class FindRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] matrix = new char[8][8];

        for (int i = 0; i < 8; i++) {
            char[] arr = sc.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
            matrix[i] = arr;
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'q') {
                    if (isRealQueen(row, col, matrix)) {
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private static boolean isRealQueen(int row, int col, char[][] matrix) {
        return checkMoves(row, col, matrix);
    }

    private static boolean checkMoves(int row, int col, char[][] matrix) {
        return checkDiagonals(row, col, matrix) && checkLines(row, col, matrix);
    }

    private static boolean checkDiagonals(int row, int col, char[][] matrix) {
        return topLeftDiagonal(row, col, matrix) && topRightDiagonal(row, col, matrix) && bottomLeftDiagonal(row, col, matrix) && bottomRightDiagonal(row, col, matrix);
    }

    private static boolean bottomRightDiagonal(int row, int col, char[][] matrix) {
        boolean diagonal = true;
        row++;
        col++;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                diagonal = false;
                break;
            }
            row++;
            col++;
        }
        return diagonal;
    }

    private static boolean bottomLeftDiagonal(int row, int col, char[][] matrix) {
        boolean diagonal = true;

        row++;
        col--;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                diagonal = false;
                break;
            }
            row++;
            col--;
        }
        return diagonal;
    }

    private static boolean topRightDiagonal(int row, int col, char[][] matrix) {
        boolean diagonal = true;
        row--;
        col++;
        while (isInBound(row, col)){
            if (matrix[row][col] == 'q') {
                diagonal = false;
                break;
            }
            row--;
            col++;
        }

        return diagonal;
    }

    private static boolean topLeftDiagonal(int row, int col, char[][] matrix) {
        boolean diagonal = true;
        row--;
        col--;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                diagonal = false;
                break;
            }
            row--;
            col--;
        }
        return diagonal;
    }

    private static boolean checkLines(int row, int col, char[][] matrix) {
        return leftLine(row, col, matrix) && rightLine(row, col, matrix) && topLine(row, col, matrix) && bottomLine(row, col, matrix);
    }

    private static boolean bottomLine(int row, int col, char[][] matrix) {
        boolean line = true;
        row++;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                line = false;
                break;
            }
            row++;
        }
        return line;
    }

    private static boolean topLine(int row, int col, char[][] matrix) {
        boolean line = true;
        row--;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                line = false;
                break;
            }
            row--;
        }
        return line;
    }

    private static boolean rightLine(int row, int col, char[][] matrix) {
        boolean line = true;
        col++;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                line = false;
                break;
            }
            col++;
        }
        return line;
    }

    private static boolean leftLine(int row, int col, char[][] matrix) {
        boolean line = true;
        col--;
        while (isInBound(row, col)) {
            if (matrix[row][col] == 'q') {
                line = false;
                break;
            }
            col--;
        }
        return line;
    }
}
