package _01_StacksAndQueues.LAB;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> printer = new ArrayDeque<>();
        String input = sc.nextLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (printer.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printer.poll());
                }
            } else {
                printer.offer(input);
            }
            input = sc.nextLine();
        }

        while (!printer.isEmpty()) {
            System.out.println(printer.poll());
        }
    }
}
