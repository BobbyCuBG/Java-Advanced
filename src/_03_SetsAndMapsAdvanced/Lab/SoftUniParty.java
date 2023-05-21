package _03_SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> partyGuests = new TreeSet<>();

        String input = sc.nextLine();
        while (!"PARTY".equals(input)) {
            partyGuests.add(input);
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!"END".equals(input)) {
            partyGuests.remove(input);
            input = sc.nextLine();
        }
        System.out.println(partyGuests.size());
        partyGuests.forEach(System.out::println);
    }
}
