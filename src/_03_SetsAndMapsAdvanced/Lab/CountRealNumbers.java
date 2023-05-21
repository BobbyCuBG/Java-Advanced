package _03_SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> doubleOccurrences = new LinkedHashMap<>();
        double[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double n : input) {
            doubleOccurrences.putIfAbsent(n, 0);
            doubleOccurrences.put(n, doubleOccurrences.get(n) + 1);
        }

        doubleOccurrences.forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));
    }
}
