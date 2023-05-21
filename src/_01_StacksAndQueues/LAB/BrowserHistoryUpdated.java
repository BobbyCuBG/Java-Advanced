package _01_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String currentUrl = "";

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();
        String navigation = sc.nextLine();

        while (!"Home".equals(navigation)) {
            if ("back".equals(navigation)) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = sc.nextLine();
                    continue;
                } else {
                    forward.push(currentUrl);
                    currentUrl = history.pop();
                    System.out.println(currentUrl);
                }
            } else if ("forward".equals(navigation)) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    history.push(currentUrl);
                    currentUrl = forward.pop();
                    System.out.println(currentUrl);
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    history.push(currentUrl);
                }
                currentUrl = navigation;
                System.out.println(currentUrl);
                forward.clear();
            }
            navigation = sc.nextLine();
        }
    }
}
