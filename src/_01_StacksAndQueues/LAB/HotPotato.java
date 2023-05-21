package _01_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kids = sc.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String kid : kids) {
            queue.offer(kid);
        }
        int counts = Integer.parseInt(sc.nextLine());
        while (queue.size() > 1) {
            for (int i = 0; i < counts; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.pollLast());
        }
        System.out.println("Last is " + queue.poll());
    }
}
