package _03_SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _11_LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        while (true) {
            List<String> input = Arrays.stream(sc.nextLine().toLowerCase().split(" "))
                    .collect(Collectors.toList());

            boolean materialsGathered = sortMaterials(keyMaterials, junk, input);
            if (materialsGathered) {
                break;
            }
        }
        keyMaterials.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static boolean sortMaterials(Map<String, Integer> keyMaterials, Map<String, Integer> junk, List<String> input) {
        String legendaryItem = "";
        for (int i = 0; i < input.size(); i++) {
            if (i % 2 == 0) {
                int value = Integer.parseInt(input.get(i));
                String material = input.get(i + 1);
                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + value);
                    if (keyMaterials.get(material) >= 250) {
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        switch (material) {
                            case "shards":
                                legendaryItem = "Shadowmourne";
                                System.out.println(legendaryItem + " obtained!");
                                break;
                            case "fragments":
                                legendaryItem = "Valanyr";
                                System.out.println(legendaryItem + " obtained!");
                                break;
                            case "motes":
                                legendaryItem = "Dragonwrath";
                                System.out.println(legendaryItem + " obtained!");
                                break;
                        }
                        break;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.put(material, junk.get(material) + value);
                }
            }
        }
        return !legendaryItem.equals("");
    }
}
