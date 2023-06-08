package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> evenOddComparator = (num1, num2) -> {
            boolean isNum1Even = num1 % 2 == 0;
            boolean isNum2Even = num2 % 2 == 0;

            if (isNum1Even && !isNum2Even) {
                return -1; // num1 is even, num2 is odd, so num1 should come first
            } else if (!isNum1Even && isNum2Even) {
                return 1; // num1 is odd, num2 is even, so num2 should come first
            } else {
                return num1.compareTo(num2); // Both are either even or odd, compare their values
            }
        };
        Arrays.sort(numbers, evenOddComparator);
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
}