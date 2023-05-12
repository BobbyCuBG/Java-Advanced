package StacksAndQueues_01.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String[] input = sc.nextLine().split("\\s+");

        for (String n : input) {
            numbers.push(Integer.valueOf(n));
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
