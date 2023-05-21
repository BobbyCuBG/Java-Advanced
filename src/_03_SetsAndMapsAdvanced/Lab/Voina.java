package _03_SetsAndMapsAdvanced.Lab;

import java.util.*;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();

        for (String numberString : sc.nextLine().split(" ")) {
            int number = Integer.parseInt(numberString);
            firstPlayer.add(number);
        }
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        for (String numberString : sc.nextLine().split(" ")) {
            int number = Integer.parseInt(numberString);
            secondPlayer.add(number);
        }

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);

            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }

        if (firstPlayer.isEmpty() || firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else if (secondPlayer.isEmpty() || secondPlayer.size() < firstPlayer.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
