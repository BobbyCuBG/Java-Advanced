package _01_StacksAndQueues.LAB;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MathPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] kids = sc.nextLine().split("\\s+");
        PriorityQueue<String> queue = new PriorityQueue<>();

        for (String kid : kids) {
            queue.offer(kid);
        }
        int cycle = 1;
        int counts = Integer.parseInt(sc.nextLine());
        while (queue.size() > 1) {
            for (int i = 1; i < counts; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int cycle) {
        return cycle > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(cycle))
                .noneMatch(n -> (cycle % n == 0));
    }
}
