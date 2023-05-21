package _03_SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> uniqueUsernames = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            uniqueUsernames.add(sc.nextLine());
        }
        uniqueUsernames.forEach(System.out::println);
    }
}
