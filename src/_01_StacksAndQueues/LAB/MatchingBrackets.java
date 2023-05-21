package _01_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String expression = sc.nextLine();
        ArrayDeque<Integer> firstBracket = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                firstBracket.push(i);
            } else if (expression.charAt(i) == ')') {
                int openFirstBracket = firstBracket.pop();
                System.out.println(expression.substring(openFirstBracket, i + 1));
            }
        }
    }
}
