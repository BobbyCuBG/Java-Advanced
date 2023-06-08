package ExamPrep_April2023._01_RubberDuck;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> first = new ArrayDeque<>();
        ArrayDeque<Integer> second = new ArrayDeque<>();

        first.push(1);
        first.push(2);
        first.push(3);
        first.push(4);
        first.push(5);

        System.out.println(first.poll());
        System.out.println(first.poll());

        second.offer(1);
        second.offer(2);
        second.offer(3);
        second.offer(4);
        second.offer(5);

        System.out.println(second.pop());
        System.out.println(second.pop());
    }
}
