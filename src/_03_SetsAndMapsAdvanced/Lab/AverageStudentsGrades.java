package _03_SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentRecord = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String studentName = input[0];
            double grade = Double.parseDouble(input[1]);

            studentRecord.putIfAbsent(studentName, new ArrayList<>());
            studentRecord.get(studentName).add(grade);
        }

        studentRecord.forEach((key, value) -> {
            double sum = 0;
            System.out.print(key + " -> ");
            for (Double grade : value) {
                sum += grade;
                System.out.printf("%.2f ", grade);
            }
            double average = sum / value.size();
            System.out.printf("(avg: %.2f)%n", average);
        });
    }
}
