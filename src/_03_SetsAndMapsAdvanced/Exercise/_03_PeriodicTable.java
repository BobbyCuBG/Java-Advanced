package _03_SetsAndMapsAdvanced.Exercise;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> perTable = new TreeSet<>();

        int numberOfElements = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfElements; i++) {
            perTable.addAll(List.of(sc.nextLine().split("\\s+")));
        }
        perTable.forEach(e -> System.out.print(e + " "));
    }
}
