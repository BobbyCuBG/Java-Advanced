package _03_SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Double>> shopCatalog = new TreeMap<>();

        String input = sc.nextLine();
        while (!"Revision".equals(input)) {
            String[] tokens = input.split(", ");
            String storeName = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopCatalog.putIfAbsent(storeName, new LinkedHashMap<>());
            shopCatalog.get(storeName).putIfAbsent(product, 0.0);
            shopCatalog.get(storeName).put(product, price);
            input = sc.nextLine();
        }

        shopCatalog.forEach((store, catalog) -> {
            System.out.println(store + "->");
            catalog.forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f%n", product, price));
        });
    }
}
