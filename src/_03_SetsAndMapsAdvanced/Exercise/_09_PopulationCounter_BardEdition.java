package _03_SetsAndMapsAdvanced.Exercise;
import java.util.*;

public class _09_PopulationCounter_BardEdition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Long> countryAndTotalPopulation = new HashMap<>();
        Map<String, Map<String, Long>> countriesAndCitiesAndPopulation = new HashMap<>();

        String input = sc.nextLine();
        while (!"report".equals(input)) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            //fill both Maps with countries
            countryAndTotalPopulation.putIfAbsent(country, 0L);
            countriesAndCitiesAndPopulation.putIfAbsent(country, new HashMap<>());

            //fill the second map with the cities and calculate the total Population for each country in the first map
            countriesAndCitiesAndPopulation.get(country).put(city, population);
            countryAndTotalPopulation.put(country, countryAndTotalPopulation.get(country) + countriesAndCitiesAndPopulation.get(country).get(city));

            input = sc.nextLine();
        }

        //sort countries by their population in descending order
        List<Map.Entry<String, Long>> countries = new ArrayList<>(countryAndTotalPopulation.entrySet());
        countries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        //print each country and total population
        for (Map.Entry<String, Long> country : countries) {
            System.out.printf("%s (total population: %d)%n", country.getKey(), country.getValue());

            //access each country's city list from the innerMap using the country key from the first map
            Map<String, Long> cities = countriesAndCitiesAndPopulation.get(country.getKey());

            //sort each city by their population in descending order
            List<Map.Entry<String, Long>> cityList = new ArrayList<>(cities.entrySet());
            cityList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

            //print each city and population
            for (Map.Entry<String, Long> city : cityList) {
                System.out.println("=>" + city.getKey() + ": " + city.getValue());
            }
        }
    }
}