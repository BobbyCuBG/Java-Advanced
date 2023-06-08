package _05_FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class _01_SortedEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Predicate<Integer> isEven = number -> number % 2 == 0;
        List<Integer> numbers = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .filter(isEven)
                .collect(Collectors.toList());

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println(numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
