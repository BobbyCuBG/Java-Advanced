package _03_SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _12_SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String regex = "\\b(?<singer>[A-Za-z]+\\s*[A-Za-z]*\\s*[A-Za-z]*) @(?<venue>[A-Za-z]+\\s*[A-Za-z]*\\s*[A-Za-z]*) (?<ticketPrice>[0-9]+) (?<count>[0-9]+)\\b";
        Pattern pattern = Pattern.compile(regex);

        Map<String, Map<String, Integer>> venueRevenue = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            String singer;
            String venue;
            int ticketPrice;
            int numberOfTickets;

            if (matcher.find()) {
                singer = matcher.group("singer");
                venue = matcher.group("venue");
                ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                numberOfTickets = Integer.parseInt(matcher.group("count"));

                venueRevenue.putIfAbsent(venue, new LinkedHashMap<>());
                venueRevenue.get(venue).putIfAbsent(singer, 0);
                venueRevenue.get(venue).put(singer, venueRevenue.get(venue).get(singer) + ticketPrice * numberOfTickets);
            }
            input = sc.nextLine();
        }
        venueRevenue.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(singer -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));
        });
    }
}
