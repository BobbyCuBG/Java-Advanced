package _05_FunctionalProgramming.Exercise;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicatePartyChatGPTHelp {
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
            Collections.sort(partyGuests);
            System.out.print(String.join(", ", partyGuests) + " are going to the party!");
        }
    }

    private static void executeCommand(List<String> partyGuests, String command, String typeOfCommand, String criteria) {
        Predicate<String> startsWithPredicate = name -> name.startsWith(criteria);
        Predicate<String> endsWithPredicate = name -> name.endsWith(criteria);
        Predicate<String> lengthPredicate = name -> name.length() == Integer.parseInt(criteria);

        switch (command) {
            case "Remove":
                Predicate<String> removePredicate;
                switch (typeOfCommand) {
                    case "StartsWith":
                        removePredicate = startsWithPredicate;
                        break;
                    case "EndsWith":
                        removePredicate = endsWithPredicate;
                        break;
                    case "Length":
                        removePredicate = lengthPredicate;
                        break;
                    default:
                        return;
                }
                partyGuests.removeIf(removePredicate);
                break;

            case "Double":
                List<String> duplicates = new ArrayList<>();
                Predicate<String> duplicatePredicate;
                switch (typeOfCommand) {
                    case "StartsWith":
                        duplicatePredicate = startsWithPredicate;
                        break;
                    case "EndsWith":
                        duplicatePredicate = endsWithPredicate;
                        break;
                    case "Length":
                        duplicatePredicate = lengthPredicate;
                        break;
                    default:
                        return;
                }
                partyGuests.stream()
                        .filter(duplicatePredicate)
                        .forEach(duplicates::add);
                partyGuests.addAll(duplicates);
                break;

            default:
                break;
        }
    }
}
