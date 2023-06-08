package _06_DefiningClasses.Exercise._09_CatLady;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Cat cat = new Cat();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String catName = tokens[1];
            double carCharacteristics = Double.parseDouble(tokens[2]);

            switch (type) {
                case "Siamese":
                    Siamese siamese = new Siamese(catName, carCharacteristics);
                    cat.getSiamese().add(siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(catName, carCharacteristics);
                    cat.getCymric().add(cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(catName, carCharacteristics);
                    cat.getStreetExtraordinaire().add(streetExtraordinaire);
                    break;
            }
            input = sc.nextLine();
        }
        String catToPrint = sc.nextLine();

        String output = cat.printCat(catToPrint);
        System.out.println(output);
    }
}
