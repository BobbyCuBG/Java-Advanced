package _03_SetsAndMapsAdvanced.Exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        String input = sc.nextLine();
        while (!"search".equals(input)) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String phoneNumber = tokens[1];

            phonebook.put(name, phoneNumber);
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!"stop".equals(input)) {
            System.out.println(phonebook.containsKey(input) ? input + " -> " + phonebook.get(input): "Contact " + input + " does not exist.");
            input = sc.nextLine();
        }
    }
}
