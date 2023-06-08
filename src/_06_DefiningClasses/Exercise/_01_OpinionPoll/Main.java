package _06_DefiningClasses.Exercise._01_OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);

            people.add(person);
        }
        people.stream().filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
