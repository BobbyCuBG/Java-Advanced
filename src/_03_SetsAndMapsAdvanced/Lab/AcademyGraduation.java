package _03_SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, double[]> studentsAndGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double[] grades = Arrays.stream(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            studentsAndGrades.putIfAbsent(name, new double[grades.length]);
            studentsAndGrades.put(name, grades);
        }
        studentsAndGrades.forEach((student, grades) -> {
            System.out.print(student + " is graduated with ");
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            double average = sum / grades.length;
            DecimalFormat format = new DecimalFormat("#.##################");
            System.out.printf(format.format(average));
            System.out.println();
        });
    }
}
