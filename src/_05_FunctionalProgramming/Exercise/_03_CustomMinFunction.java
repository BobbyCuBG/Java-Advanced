package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> number = Arrays.stream(sc.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        Function<Set<Integer>, Integer> num = Collections::min;
        System.out.println(num.apply(number));
    }
}
