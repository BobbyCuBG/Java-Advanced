package ExamPrep_April2023._02_TheSquirrel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fieldSize = Integer.parseInt(sc.nextLine());

        char[][] field = new char[fieldSize][fieldSize];

        int squirrelRow = -1;
        int squirrelCol = -1;
        int hazelnutCount = 0;
        String[] commands = sc.nextLine().split(",\\s+");
        for (int row = 0; row < field.length; row++) {
            char[] lineRow = new char[fieldSize];
            String line = sc.nextLine();
            for (int col = 0; col < line.length(); col++) {
                lineRow[col] = line.charAt(col);

                if (line.charAt(col) == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
            field[row] = lineRow;
        }

        for (String command : commands) {
            switch (command) {
                case "left":
                    squirrelCol--;

                    if (squirrelStepsOutsideTheField(squirrelRow, squirrelCol, fieldSize)) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnutCount++;
                        if (hazelnutCount == 3) {
                            System.out.println("Good job! You have collected all hazelnuts!");
                            System.out.println("Hazelnuts collected: " + hazelnutCount);
                            return;
                        } else {
                            field[squirrelRow][squirrelCol] = '*';
                        }
                    }
                    break;
                case "right":

                    squirrelCol++;
                    if (squirrelStepsOutsideTheField(squirrelRow, squirrelCol, fieldSize)) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnutCount++;
                        if (hazelnutCount == 3) {
                            System.out.println("Good job! You have collected all hazelnuts!");
                            System.out.println("Hazelnuts collected: " + hazelnutCount);
                            return;
                        } else {
                            field[squirrelRow][squirrelCol] = '*';
                        }
                    }
                    break;
                case "up":
                    squirrelRow--;

                    if (squirrelStepsOutsideTheField(squirrelRow, squirrelCol, fieldSize)) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnutCount++;
                        if (hazelnutCount == 3) {
                            System.out.println("Good job! You have collected all hazelnuts!");
                            System.out.println("Hazelnuts collected: " + hazelnutCount);
                            return;
                        } else {
                            field[squirrelRow][squirrelCol] = '*';
                        }
                    }
                    break;
                case "down":
                    squirrelRow++;

                    if (squirrelStepsOutsideTheField(squirrelRow, squirrelCol, fieldSize)) {
                        System.out.println("The squirrel is out of the field.");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 't') {
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        System.out.println("Hazelnuts collected: " + hazelnutCount);
                        return;
                    }

                    if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnutCount++;
                        if (hazelnutCount == 3) {
                            System.out.println("Good job! You have collected all hazelnuts!");
                            System.out.println("Hazelnuts collected: " + hazelnutCount);
                            return;
                        } else {
                            field[squirrelRow][squirrelCol] = '*';
                        }
                    }
                    break;
            }
        }

        System.out.println("There are more hazelnuts to collect.");
        System.out.println("Hazelnuts collected: " + hazelnutCount);
    }

    private static boolean squirrelStepsOutsideTheField(int row, int col, int size) {
        return row < 0 || col < 0 || row >= size || col >= size;
    }
}
