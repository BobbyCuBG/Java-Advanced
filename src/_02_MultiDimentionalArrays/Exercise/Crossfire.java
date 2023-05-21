package _02_MultiDimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] range = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = range[0];
        int cols = range[1];

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, cols);

        String command = sc.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+"); // 3 4 1
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]); //индексът на елемента в листа
            int radius = Integer.parseInt(tokens[2]);

            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if (currentRow < 0 || currentRow >= rows) {
                    continue;
                }
                if (isInMatrix(currentRow, col, matrix)) {
                    matrix.get(currentRow).remove(col);
                }
            }

            for (int currentCol = col + radius; currentCol >= col - radius; currentCol--) {
                if (currentCol < 0 || currentCol >= cols) {
                    continue;
                }
                if (isInMatrix(row, currentCol, matrix)) {
                    matrix.get(row).remove(currentCol);
                }
            }

           matrix.removeIf(List::isEmpty);

            command = sc.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }
    public static void printMatrix(List<List<Integer>> matrix) {
        matrix.forEach(row -> {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        });
    }
}
