package _05_FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Consumer<List<Integer>> printList = nums -> nums.forEach(n -> System.out.print(n + " "));
        String input = sc.nextLine();
        while (!"end".equals(input)) {
            if (input.equals("print")) {
                printList.accept(numbers);
                System.out.println();
            } else {
                Function<List<Integer>, List<Integer>> function = getFunctionCommand(input);
                numbers = function.apply(numbers);
            }
            input = sc.nextLine();
        }

    }

    private static Function<List<Integer>, List<Integer>> getFunctionCommand(String input) {
        Function<List<Integer>, List<Integer>> func = null;
        switch (input) {
            case "add":
                List<Integer> addList = new ArrayList<>();
                func = numbers -> {
                    for (Integer number : numbers) {
                        addList.add(number + 1);
                    }
                    return addList;
                };
                break;
            case "multiply":
                List<Integer> multiplyList = new ArrayList<>();
                func = numbers -> {
                    for (Integer number : numbers) {
                        multiplyList.add(number * 2);
                    }
                    return multiplyList;
                };
                break;
            case "subtract":
                List<Integer> subtractList = new ArrayList<>();
                func = numbers -> {
                    for (Integer number : numbers) {
                        subtractList.add(number - 1);
                    }
                    return subtractList;
                };
                break;
        }
        return func;
    }
}