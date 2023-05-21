package _03_SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lengths = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < lengths[0]; i++) {
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < lengths[1]; i++) {
            secondSet.add(Integer.parseInt(sc.nextLine()));
        }
        firstSet.removeIf(number -> !secondSet.contains(number));
        firstSet.forEach(n -> System.out.print(n + " "));
    }
}
