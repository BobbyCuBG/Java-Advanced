package _03_SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Character, Integer> symbolCounts = new TreeMap<>();
        String textInput = sc.nextLine();
        for (int i = 0; i < textInput.length(); i++) {
            char currChar = textInput.charAt(i);
            symbolCounts.putIfAbsent(currChar, 0);
            symbolCounts.put(currChar, symbolCounts.get(currChar) + 1);
        }
        symbolCounts.forEach((k, v) -> System.out.println(k + ": " + v + " time/s"));
    }
}
