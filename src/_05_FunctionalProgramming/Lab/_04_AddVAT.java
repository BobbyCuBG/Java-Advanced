package _05_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _04_AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Double> prices = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Consumer<Double> printPriceWithAddedVAT = number -> System.out.printf("%.2f%n", number * 1.2);

        System.out.println("Prices with VAT:");
        prices.forEach(printPriceWithAddedVAT);
    }
}
