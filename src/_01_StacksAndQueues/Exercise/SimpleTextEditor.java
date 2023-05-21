package _01_StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> history = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        for (int i = 1; i <= n; i++) {
           String commands = sc.nextLine();
            String[] tokens = commands.split("\\s+");

            switch (tokens[0]) {
                case "1":
                    history.push(text.toString());
                    text.append(tokens[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    history.push(text.toString());
                    int startIndex = text.length() - count;
                    text.delete(startIndex, text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
                    break;
                case "4":
                    if (!history.isEmpty()) {
                        text = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
    }
}
