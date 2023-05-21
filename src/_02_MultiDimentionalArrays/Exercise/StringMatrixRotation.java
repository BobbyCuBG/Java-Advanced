package _02_MultiDimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\d+");
        String input = sc.nextLine();
        Matcher matcher = pattern.matcher(input);

        int rotationDegree = getRotationDegree(matcher) % 360;
        List<String> list = new ArrayList<>();

        input = sc.nextLine();
        while (!"END".equals(input)) {
            list.add(input);
            input = sc.nextLine();
        }

        int rows = list.size();
        int cols = findLongestString(list);
        char[][] matrix = fillMatrix(list, rows, cols);

        rotate(rotationDegree, rows, cols, matrix);
    }

    private static char[][] fillMatrix(List<String> list, int rows, int cols) {
        char[][] matrix = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            String element = list.get(r);
            StringBuilder elementToChar = new StringBuilder();
            for (int i = 0; i < element.length(); i++) {
                elementToChar.append(element.charAt(i));
            }
            elementToChar.append(" ".repeat(Math.max(0, cols - element.length())));
            char[] toChar = elementToChar.toString().toCharArray();
            matrix[r] = toChar;
        }
        return matrix;
    }

    private static int getRotationDegree(Matcher matcher) {
        int number = 0;
        if (matcher.find()) {
            number = Integer.parseInt(matcher.group());
        }
        return number;
    }

    private static int findLongestString(List<String> list) {
        int n = 0;
        for (String l : list) {
            int length = l.length();
            if (length > n) {
                n = length;
            }
        }
        return n;
    }

    private static void rotate(int angleRotation, int rows, int cols, char[][] matrix) {
        if (angleRotation == 90) {
            for (int col = 0; col < cols ; col++) {
                for (int row = rows - 1; row >= 0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }

        } else if (angleRotation == 180) {
            for (int row = rows - 1; row >= 0 ; row--) {
                for (int col = cols - 1; col >= 0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angleRotation == 270) {
            for (int col = cols - 1; col >= 0 ; col--) {
                for (int row = 0; row < rows ; row++) {
                    System.out.print(matrix[row][col]);

                }
                System.out.println();
            }
        } else {
            for (int row = 0; row < rows ; row++) {
                for (int col = 0; col < cols ; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }
}
