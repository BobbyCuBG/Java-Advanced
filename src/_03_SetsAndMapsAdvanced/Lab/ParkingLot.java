package _03_SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = sc.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");

            String command = tokens[0];
            String plateNumber = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(plateNumber);
                    break;
                case "OUT":
                    parkingLot.remove(plateNumber);
                    break;
            }
            input = sc.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
