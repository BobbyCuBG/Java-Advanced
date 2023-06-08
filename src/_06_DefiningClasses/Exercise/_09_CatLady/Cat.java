package _06_DefiningClasses.Exercise._09_CatLady;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private final List<Siamese> siamese;
    private final List<Cymric> cymric;
    private final List<StreetExtraordinaire> streetExtraordinaire;

    public Cat() {
        this.siamese = new ArrayList<>();
        this.cymric = new ArrayList<>();
        this.streetExtraordinaire = new ArrayList<>();
    }

    public List<Siamese> getSiamese() {
        return siamese;
    }

    public List<Cymric> getCymric() {
        return cymric;
    }

    public List<StreetExtraordinaire> getStreetExtraordinaire() {
        return streetExtraordinaire;
    }

    String printCat(String input) {
        boolean catFound = false;

        String output = "";
        while (!catFound) {
            for (Siamese cat : getSiamese()) {
                if (cat.getName().equals(input)) {
                    output = String.format("Siamese %s %.2f", cat.getName(), cat.getEarSize());
                    catFound = true;
                    break;
                }
            }
            for (Cymric cat : getCymric()) {
                if (cat.getName().equals(input)) {
                    output = String.format("Cymric %s %.2f", cat.getName(), cat.getFurLength());
                    catFound = true;
                    break;
                }
            }
            for (StreetExtraordinaire cat : getStreetExtraordinaire()) {
                if (cat.getName().equals(input)) {
                    output = String.format("StreetExtraordinaire %s %.2f", cat.getName(), cat.getDecibelsOfMeows());
                    catFound = true;
                    break;
                }
            }
        }
        return output;
    }
}
