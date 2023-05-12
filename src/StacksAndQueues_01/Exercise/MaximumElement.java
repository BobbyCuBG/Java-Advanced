package StacksAndQueues_01.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            switch (tokens[0]) {
                case "1":
                    elements.push(Integer.valueOf(tokens[1]));
                    break;
                case "2":
                    elements.pop();
                    break;
                case "3":
                    int maximumElement = getMaximumElement(elements);
                    System.out.println(maximumElement);
                    break;
            }
        }
    }

    private static int getMaximumElement(ArrayDeque<Integer> elements) {
        ArrayDeque<Integer> tempArray = new ArrayDeque<>();
        int maxElement = elements.pop();
        tempArray.push(maxElement);

         while (!elements.isEmpty()) {
             int currDigit = elements.pop();
             tempArray.push(currDigit);

             if (currDigit > maxElement) {
                 maxElement = currDigit;
             }
         }
        for (Integer n : tempArray) {
            elements.push(n);
        }
        return maxElement;
    }
}
