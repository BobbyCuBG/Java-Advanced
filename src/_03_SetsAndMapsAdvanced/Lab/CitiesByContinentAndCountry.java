package _03_SetsAndMapsAdvanced.Lab;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, List<String>>> globalMap = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = sc.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            globalMap.putIfAbsent(continent, new LinkedHashMap<>());
            globalMap.get(continent).putIfAbsent(country, new ArrayList<>());
            globalMap.get(continent).get(country).add(city);
        }

        globalMap.forEach((continent, country) -> {
            System.out.println(continent + ":");
            country.forEach((c, cityList) -> {
                System.out.printf("  %s -> ", c);
                System.out.print(String.join(", ", cityList));
                System.out.println();
            });
        });
    }
}
