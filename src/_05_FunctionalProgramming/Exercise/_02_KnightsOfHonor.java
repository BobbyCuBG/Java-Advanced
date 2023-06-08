package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> input = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Consumer<String> printingMethod = line -> System.out.println("Sir " + line);

        input.forEach(printingMethod);
    }
}
