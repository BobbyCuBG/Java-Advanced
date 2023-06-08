package _06_DefiningClasses.Exercise._07_Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Person> peopleList = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            peopleList.putIfAbsent(personName, new Person(personName));

            switch (tokens[1]) {
                case "company":
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);

                    Company company = new Company(companyName, department, salary);
                    peopleList.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);

                    if (peopleList.get(personName).getPokemon() == null) {
                        peopleList.get(personName).setPokemon(new ArrayList<>());
                        peopleList.get(personName).getPokemon().add(pokemon);
                    } else {
                        peopleList.get(personName).getPokemon().add(pokemon);
                    }
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];

                    Parents parent = new Parents(parentName, parentBirthday);

                    if (peopleList.get(personName).getParents() == null) {
                        peopleList.get(personName).setParents(new ArrayList<>());
                        peopleList.get(personName).getParents().add(parent);
                    } else {
                        peopleList.get(parentName).getParents().add(parent);
                    }
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];

                    Children child = new Children(childName, childBirthday);

                    if (peopleList.get(personName).getChildren() == null) {
                        peopleList.get(personName).setChildren(new ArrayList<>());
                        peopleList.get(personName).getChildren().add(child);
                    } else {
                        peopleList.get(personName).getChildren().add(child);
                    }
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    peopleList.get(personName).setCar(car);
                    break;
            }
            input = sc.nextLine();
        }
        String nameToPrint = sc.nextLine();
        peopleList.entrySet()
                .stream().filter(person -> person.getValue().getName().equals(nameToPrint))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.println("Company:");
                    if (e.getValue().getCompany() != null) {
                        System.out.printf("%s %s %.2f%n", e.getValue().getCompany().getCompanyName(), e.getValue().getCompany().getDepartment(), e.getValue().getCompany().getSalary());
                    }
                    System.out.println("Car:");
                    if (e.getValue().getCar() != null) {
                        System.out.printf("%s %d%n", e.getValue().getCar().getCarModel(), e.getValue().getCar().getCarSpeed());
                    }
                    System.out.println("Pokemon:");
                    if (e.getValue().getPokemon() != null) {
                        for (Pokemon pokemon : e.getValue().getPokemon()) {
                            System.out.printf("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType());
                        }
                    }
                    System.out.println("Parents:");
                    if (e.getValue().getParents() != null)  {
                        for (Parents parent : e.getValue().getParents()) {
                            System.out.printf("%s %s%n", parent.getParentName(), parent.getParentBirthday());
                        }
                    }
                    System.out.println("Children:");
                    if (e.getValue().getChildren() != null) {
                        for (Children child : e.getValue().getChildren()) {
                            System.out.printf("%s %s%n", child.getChildName(), child.getChildBirthday());
                        }
                    }
                });
    }
}
