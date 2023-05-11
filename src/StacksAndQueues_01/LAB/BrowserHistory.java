package StacksAndQueues_01.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String currentUrl = "";

        ArrayDeque<String> history = new ArrayDeque<>();
        String navigation = sc.nextLine();

        while (!"Home".equals(navigation)) {
            if ("back".equals(navigation)) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    navigation = sc.nextLine();
                    continue;
                } else {
                    currentUrl = history.pop();
                }
            } else {
                if (!currentUrl.isEmpty()) {
                    history.push(currentUrl);
                }
                currentUrl = navigation;
            }
            System.out.println(currentUrl);
            navigation = sc.nextLine();
        }
    }
}
