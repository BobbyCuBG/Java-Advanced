package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class _13_DragonArmy {
    public static void main(String[] args) {

        Map<String, List<Double>> typesOfDragonAndAverages = new LinkedHashMap<>();
        Map<String, Map<String, List<Integer>>> dragonList = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String typeOfDragon = input[0];
            String nameOfDragon = input[1];
            String damageString = input[2];
            String healthString = input[3];
            String armorString = input[4];

            int damage = checkIfDamageDefault(damageString);
            int health = checkIfHealthDefault(healthString);
            int armor = checkIfArmorDefault(armorString);
            fillTheMaps(typesOfDragonAndAverages, dragonList, typeOfDragon, nameOfDragon, damage, health, armor);
        }
        dragonList.forEach((types, names) -> {
            double damageSum = 0;
            double healthSum = 0;
            double armorSum = 0;


            for (List<Integer> name : names.values()) {
                damageSum += name.get(0);
                healthSum += name.get(1);
                armorSum += name.get(2);
            }
            typesOfDragonAndAverages.get(types).add(damageSum / names.size());
            typesOfDragonAndAverages.get(types).add(healthSum / names.size());
            typesOfDragonAndAverages.get(types).add(armorSum / names.size());
        });
        typesOfDragonAndAverages.forEach((type, averages) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averages.get(0), averages.get(1), averages.get(2));
            dragonList.get(type).forEach((dragon, stats) -> {
                int damage = stats.get(0);
                int health = stats.get(1);
                int armor = stats.get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon, damage, health, armor);
            });
        });
    }

    private static void fillTheMaps(Map<String, List<Double>> typesOfDragonAndAverages, Map<String, Map<String, List<Integer>>> dragonList, String typeOfDragon, String nameOfDragon, int damage, int health, int armor) {
        typesOfDragonAndAverages.putIfAbsent(typeOfDragon, new ArrayList<>());
        dragonList.putIfAbsent(typeOfDragon, new TreeMap<>());
        dragonList.get(typeOfDragon).putIfAbsent(nameOfDragon, new ArrayList<>());
        if (dragonList.get(typeOfDragon).containsKey(nameOfDragon)) {
            dragonList.get(typeOfDragon).get(nameOfDragon).clear();
        }
        dragonList.get(typeOfDragon).get(nameOfDragon).add(damage);
        dragonList.get(typeOfDragon).get(nameOfDragon).add(health);
        dragonList.get(typeOfDragon).get(nameOfDragon).add(armor);
    }

    private static int checkIfDamageDefault(String damage) {
        return damage.equals("null") ? 45 : Integer.parseInt(damage);
    }

    private static int checkIfHealthDefault(String health) {
        return health.equals("null") ? 250 : Integer.parseInt(health);
    }

    private static int checkIfArmorDefault(String armor) {
        return armor.equals("null") ? 10 : Integer.parseInt(armor);
    }
}
