package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int range = Integer.parseInt(sc.nextLine());

        int[] sequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i <= range; i++) {
            boolean isDividable = true;
            for (int n : sequence) {
                Predicate<Integer> dividable = number -> number % n == 0;
                if (!dividable.test(i)) {
                    isDividable = false;
                    break;
                }
            }
            if (isDividable) {
                System.out.print(i + " ");
            }
        }
    }
}
