package StacksAndQueues_01.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] elements = sc.nextLine().split("\\s+");
        int elementsToPush = Integer.parseInt(elements[0]);
        int elementsToPop = Integer.parseInt(elements[1]);
        int checker = Integer.parseInt(elements[2]);

        ArrayDeque<Integer> digits = new ArrayDeque<>();

        String[] input = sc.nextLine().split("\\s+");

        for (int i = 0; i < elementsToPush; i++) {
            digits.push(Integer.valueOf(input[i]));
        }

        for (int i = 0; i < elementsToPop; i++) {
            digits.pop();
        }

        if (digits.contains(checker)) {
            System.out.println("true");
        } else if (digits.isEmpty()) {
            System.out.println(0);
        } else {
            int smallestNumber = findSmallestNumber(digits);
            System.out.println(smallestNumber);
        }
    }

    private static int findSmallestNumber(ArrayDeque<Integer> digits) {
        int smallestNumber = digits.pop();
        while (!digits.isEmpty()) {
            int currentDigit = digits.pop();
            if (currentDigit < smallestNumber) {
                smallestNumber = currentDigit;
            }
        }
        return  smallestNumber;
    }
}
