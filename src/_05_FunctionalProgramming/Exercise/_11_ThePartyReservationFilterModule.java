package _05_FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> partyGuests = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> appliedFilters = new HashMap<>();

        String input = sc.nextLine();
        while (!"Print".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            String criteria = tokens[2];

            String name = filterType + " " + criteria;
            switch (command) {
                case "Add filter":
                    Predicate<String> predicate;
                    switch (filterType) {
                        case "Starts with":
                            predicate = s -> s.startsWith(criteria);
                            appliedFilters.putIfAbsent(name, predicate);
                            break;
                        case "Ends with":
                            predicate = s -> s.endsWith(criteria);
                            appliedFilters.putIfAbsent(name, predicate);
                            break;
                        case "Length":
                            predicate = s -> s.length() == Integer.parseInt(criteria);
                            appliedFilters.putIfAbsent(name, predicate);
                            break;
                        case "Contains":
                            predicate = s -> s.contains(criteria);
                            appliedFilters.putIfAbsent(name, predicate);
                            break;
                    }
                    break;
                case "Remove filter":
                    appliedFilters.remove(name);
                    break;
            }
            input = sc.nextLine();
        }

        for (String guest : partyGuests) {
            boolean isGoing = !appliedFilters.values().stream().anyMatch(filter -> filter.test(guest));
            if (isGoing) {
                System.out.print(guest + " ");
            }
        }
    }
}
