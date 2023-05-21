package _02_MultiDimentionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String[][] matrix = new String[range[0]][range[1]];

        char firstChar = 'a';
        char secondChar = 'a';
        char thirdChar = 'a';

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < range[1]; col++) {
                matrix[row][col] = String.valueOf(firstChar) + String.valueOf(secondChar) + String.valueOf(thirdChar);
                secondChar++;
            }
            secondChar = firstChar;
            firstChar++;
            secondChar++;
            thirdChar++;
        }
        Arrays.stream(matrix).forEach(string -> {
            for (String chars : string) {
                System.out.print(chars + " ");
            }
            System.out.println();
        });

    }
}
