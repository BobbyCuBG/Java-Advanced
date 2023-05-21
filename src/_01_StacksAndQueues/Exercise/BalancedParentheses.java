package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                queue.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (queue.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                char front = queue.pollFirst();
                if ((c == '}' && front != '{') || (c == ']' && front != '[') || (c == ')' && front != '(')) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        if (queue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}