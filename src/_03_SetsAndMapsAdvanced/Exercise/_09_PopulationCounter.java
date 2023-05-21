package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class _09_PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Long> countryAndTotalPopulation = new LinkedHashMap<>();
        Map<String, Map<String, Long>> countriesAndCitiesAndPopulation = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            //fill both Maps with countries
            countryAndTotalPopulation.putIfAbsent(country, 0L);
            countriesAndCitiesAndPopulation.putIfAbsent(country, new LinkedHashMap<>());

            //fill the second map with the cities and calculate the total Population for each country in the first map
            countriesAndCitiesAndPopulation.get(country).put(city, population);
            countryAndTotalPopulation.put(country, countryAndTotalPopulation.get(country) + countriesAndCitiesAndPopulation.get(country).get(city));

            input = sc.nextLine();
        }
        countryAndTotalPopulation.entrySet().stream()
                //sort countries by their population in descending order
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(country -> {
                    // print each country and total population
                    System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());
                    //access each country's city list from the innerMap using the country key from the first map
                    countriesAndCitiesAndPopulation.get(country.getKey()).entrySet()
                            .stream()
                            //sort each city by their population in descending order
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            //print each city and population
                            .forEach((city) -> System.out.println("=>" + city.getKey() + ": " + city.getValue()));

                });
    }
}
