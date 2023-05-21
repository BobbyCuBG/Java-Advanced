package _03_SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> nameAndFixedEmail = new LinkedHashMap<>();
        Pattern emailFilter = Pattern.compile("\\.(?<extention>com|us|uk)");

        String nameInput = sc.nextLine();
        while (!"stop".equals(nameInput)) {
            String emailInput = sc.nextLine().toLowerCase();
            Matcher matcher = emailFilter.matcher(emailInput);
            if (!matcher.find()) {
                nameAndFixedEmail.put(nameInput, emailInput);
            }
            nameInput = sc.nextLine();
        }
        nameAndFixedEmail.forEach((name, email) -> System.out.println(name + " -> " + email));
    }
}
