package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Function<List<Integer>, Integer> sumOfNumbers = numbers -> {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }
            return sum;
        };

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Count = " + numbers.size());
        System.out.println("Sum = " + sumOfNumbers.apply(numbers));
    }
}
