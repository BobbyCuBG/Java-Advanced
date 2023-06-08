package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int dividableNumber = Integer.parseInt(sc.nextLine());
        Collections.reverse(numbers);

        Predicate<Integer> byDividable = n -> n % dividableNumber != 0;
        numbers.stream()
                .filter(byDividable)
                .forEach(n -> System.out.print(n + " "));
    }
}
