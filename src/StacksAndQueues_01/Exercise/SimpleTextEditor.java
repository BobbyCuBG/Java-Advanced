package StacksAndQueues_01.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> history = new ArrayDeque<>();
        history.push("");
        StringBuilder text = new StringBuilder();

        String commands = sc.nextLine();
        for (int i = 1; i <= n; i++) {
            String[] tokens = commands.split("\\s+");

            switch (tokens[0]) {
                case "1":
                    history.push(tokens[1]);
                    text.append(tokens[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    for (int j = 0; j < count; j++) {
                        text.deleteCharAt(text.length() - 1);
                    }
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
            commands = sc.nextLine();
        }
    }
}
