package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostFix_ToBeAnalyzed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> operators = new ArrayDeque<>();

        for (String currentOperator : input) {
            switch (currentOperator) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                case "(":
                    if (operators.isEmpty() || hasLowerPrecedence(operators.peek(), currentOperator)) {
                        operators.push(currentOperator);
                    } else {
                        while (!hasLowerPrecedence(operators.peek(), currentOperator)) {
                            System.out.print(operators.pop() + " ");
                            if (operators.isEmpty()) {
                                break;
                            }
                        }

                        operators.push(currentOperator);
                    }
                    break;
                case ")":
                    while (!operators.peek().equals("(")) {
                        System.out.print(operators.pop() + " ");
                    }
                    operators.pop();
                    break;
                default:
                    System.out.print(currentOperator + " ");
            }
        }

        while (!operators.isEmpty()) {
            System.out.print(operators.pop() + " ");
        }
    }

    private static boolean hasLowerPrecedence(String current, String next) {
        int currentOperatorPrecedence = precedence(current);
        int nextOperatorPrecedence = precedence(next);
        if (currentOperatorPrecedence < nextOperatorPrecedence) {
            return true;
        } else if (currentOperatorPrecedence == nextOperatorPrecedence) {
            return currentOperatorPrecedence == 3 || currentOperatorPrecedence == 4;
        } else {
            return currentOperatorPrecedence == 4;
        }
    }

    private static int precedence(String operator) {
        int precedence;
        switch (operator) {
            case "+":
            case "-":
                precedence = 1;
                break;
            case "*":
            case "/":
                precedence = 2;
                break;
            case "^":
                precedence = 3;
                break;
            case "(":
                precedence = 4;
                break;
            default:
                precedence = 0;
                break;
        }

        return precedence;
    }
}