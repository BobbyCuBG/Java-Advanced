package _05_FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(",\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            people.put(name, age);
        }

        String condition = sc.nextLine();
        int ageCondition = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        filterAndPrintPeople(people, condition, ageCondition, format);
    }

    private static void filterAndPrintPeople(Map<String, Integer> people, String cond, int ageCond, String form) {
        Predicate<Integer> tester = createTester(cond, ageCond);
        Consumer<Map.Entry<String, Integer>> printer =
                createPrinter(form);
        printFilteredStudent(people, tester, printer);
    }

    private static Predicate<Integer> createTester(String cond, int ageCond) {
        Predicate<Integer> tester = null;

        switch (cond) {
            case "younger":
                tester = x -> x <= ageCond;
                break;
            case "older":
                tester = x -> x >= ageCond;
                break;
        }
        return tester;
    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String form) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        switch (form) {
            case "name age":
                printer = person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
                break;
            case "name":
                printer = person -> System.out.printf("%s%n", person.getKey());
                break;
            case "age":
                printer = person -> System.out.printf("%d%n", person.getValue());
                break;
        }
        return printer;
    }

    private static void printFilteredStudent(Map<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {
        people.entrySet().stream()
                .filter(e -> tester.test(e.getValue()))
                .forEach(printer);
    }
}
