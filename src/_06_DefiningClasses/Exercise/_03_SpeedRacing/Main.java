package _06_DefiningClasses.Exercise._03_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Car> raceCars = new LinkedHashSet<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carData = sc.nextLine().split("\\s+");

            String model = carData[0];
            int fuelAmount = Integer.parseInt(carData[1]);
            double fuelCost = Double.parseDouble(carData[2]);

            Car car = new Car(model, fuelAmount, fuelCost);
            raceCars.add(car);
        }

        String input = sc.nextLine();
        while (!"End".equals(input)) {
            String carModel = input.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(input.split("\\s+")[2]);

            raceCars.forEach(car -> {
                if (car.getModel().equals(carModel)) {
                    double fuelNeeded = car.travelDistance(amountOfKm, car.getFuelCost());

                    if (fuelNeeded <= car.getFuelAmount()) {
                        car.setFuelAmount(car.getFuelAmount() - fuelNeeded);
                        car.setDistanceTraveled(car.getDistanceTraveled() + amountOfKm);
                    } else {
                        System.out.println("Insufficient fuel for the drive");
                    }
                }
            });
            input = sc.nextLine();
        }
        raceCars.forEach(car -> System.out.printf("%s %.2f %d%n", car.getModel(), car.getFuelAmount(), car.getDistanceTraveled()));
    }
}
