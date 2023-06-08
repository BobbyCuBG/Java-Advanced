package ExamPrep_April2023._01_RubberDuck;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] firstSequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondSequence = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> timeItTakesForATask = new ArrayDeque<>();
        ArrayDeque<Integer> numberOfTasks = new ArrayDeque<>();

        for (int digit : firstSequence) {
            timeItTakesForATask.offer(digit);
        }

        for (int digit : secondSequence) {
            numberOfTasks.push(digit);
        }

        int darthVaderDucks = 0;
        int thorDucks = 0;
        int bigBlueRubberDucks = 0;
        int smallYellowRubberDucks = 0;


        while (!numberOfTasks.isEmpty()) {
            int timeItTakes = timeItTakesForATask.peek();
            int task = numberOfTasks.peek();
            int sum = timeItTakes * task;
            if (sum >= 0 && sum <= 60) {
                darthVaderDucks++;
                timeItTakesForATask.pop();
                numberOfTasks.poll();
            } else if (sum > 60 && sum <= 120) {
                thorDucks++;
                timeItTakesForATask.pop();
                numberOfTasks.poll();
            } else if (sum > 120 && sum <= 180) {
                bigBlueRubberDucks++;
                timeItTakesForATask.pop();
                numberOfTasks.poll();
            } else if (sum > 180 && sum <= 240) {
                smallYellowRubberDucks++;
                timeItTakesForATask.pop();
                numberOfTasks.poll();
            } else if (sum > 240) {
                task -= 2;
                timeItTakesForATask.pop();
                numberOfTasks.poll();

                timeItTakesForATask.offer(timeItTakes);
                numberOfTasks.push(task);
            }
        }
        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + darthVaderDucks);
        System.out.println("Thor Ducky: " + thorDucks);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucks);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucks);
    }
}
