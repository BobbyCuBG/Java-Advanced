package _05_FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class _06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] range = sc.nextLine().split("\\s+");
        String command = sc.nextLine();

        int startIndex = Integer.parseInt(range[0]);
        int endIndex = Integer.parseInt(range[1]);

        Predicate<Integer> isEven = number -> number % 2 == 0;

        printNumbers(startIndex, endIndex, command, isEven);
    }

    private static void printNumbers(int startIndex, int endIndex, String command, Predicate<Integer> isEven) {
        switch (command) {
            case "even":
                for (int i = startIndex; i <= endIndex; i++) {
                    if (isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                }
                break;
            case "odd":
                for (int i = startIndex; i <= endIndex; i++) {
                    if (!isEven.test(i)) {
                        System.out.print(i + " ");
                    }
                }
                break;
        }
    }
}
