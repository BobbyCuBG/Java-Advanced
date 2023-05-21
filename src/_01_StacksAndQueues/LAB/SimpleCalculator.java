package _01_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] expression = sc.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>(Arrays.asList(expression));

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
            }
        }
        System.out.println(stack.pop());
    }
}
