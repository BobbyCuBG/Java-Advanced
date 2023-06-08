package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Predicate<String> isUpperCase = word -> Character.isUpperCase(word.charAt(0));

        List<String> text = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(text.size());
        text.forEach(System.out::println);
    }
}
