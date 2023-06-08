package _05_FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _10_PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> partyGuests = Arrays.stream(sc.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = sc.nextLine();
        while (!"Party!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String typeOfCommand = tokens[1];
            String criteria = tokens[2];

            executeCommand(partyGuests, command, typeOfCommand, criteria);
            input = sc.nextLine();
        }
        if (partyGuests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            partyGuests.sort(Comparator.naturalOrder());
            String party = String.join(", ", partyGuests);
            System.out.print(party + " are going to the party!");
        }
    }

    private static void executeCommand(List<String> partyGuests, String command, String typeOfCommand, String criteria) {
        switch (command) {
            case "Remove":
                switch (typeOfCommand) {
                    case "StartsWith":
                        int critLength = criteria.length();
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            String nameSubstring = name.substring(0, critLength);

                            if (criteria.equals(nameSubstring)) {
                                partyGuests.remove(name);
                                i--;
                            }
                        }
                        break;
                    case "EndsWith":
                        int criteriaLength = criteria.length();
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            String nameSubstring = name.substring(name.length() - criteriaLength);

                            if (criteria.equals(nameSubstring)) {
                                partyGuests.remove(name);
                                i--;
                            }
                        }
                        break;
                    case "Length":
                        int criterLength = Integer.parseInt(criteria);
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            if (name.length() == criterLength) {
                                partyGuests.remove(name);
                                i--;
                            }
                        }
                        break;
                }
                break;
            case "Double":
                switch (typeOfCommand) {
                    case "StartsWith":
                        int critLength = criteria.length();
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            String nameSubstring = name.substring(0, critLength);

                            if (criteria.equals(nameSubstring)) {
                                partyGuests.add(name);
                                i++;
                            }
                        }
                        break;
                    case "EndsWith":
                        int criteriaLength = criteria.length();
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            String nameSubstring = name.substring(name.length() - criteriaLength);

                            if (criteria.equals(nameSubstring)) {
                                partyGuests.add(name);
                                i++;
                            }
                        }
                        break;
                    case "Length":
                        int criterLength = Integer.parseInt(criteria);
                        for (int i = 0; i < partyGuests.size(); i++) {
                            String name = partyGuests.get(i);
                            if (name.length() == criterLength) {
                                partyGuests.add(i, name);
                                i++;
                            }
                        }
                        break;
                }
                break;
        }
    }
}
