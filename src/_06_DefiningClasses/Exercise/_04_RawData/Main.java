package _06_DefiningClasses.Exercise._04_RawData;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Set<Car> listOfCars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);

            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];

            double tyre1Pressure = Double.parseDouble(input[5]);
            int tyre1Age = Integer.parseInt(input[6]);

            double tyre2Pressure = Double.parseDouble(input[7]);
            int tyre2Age = Integer.parseInt(input[8]);

            double tyre3Pressure = Double.parseDouble(input[9]);
            int tyre3Age = Integer.parseInt(input[10]);

            double tyre4Pressure = Double.parseDouble(input[11]);
            int tyre4Age = Integer.parseInt(input[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tires = new Tire(tyre1Pressure, tyre1Age, tyre2Pressure, tyre2Age, tyre3Pressure, tyre3Age, tyre4Pressure, tyre4Age);

            Car car = new Car(model, engine, cargo, tires);
            listOfCars.add(car);
        }
        String cargoType = sc.nextLine();

        if (cargoType.equals("fragile")) {

            listOfCars.forEach(car -> {
                if (car.getCarCargoType().equals("fragile") && car.getTyrePressure()) {
                    System.out.println(car.getModel());
                }
            });
        } else if (cargoType.equals("flamable")) {
            listOfCars.forEach(car -> {
                if (car.getCarCargoType().equals("flamable") && car.getEnginePowerGreaterThan()) {
                    System.out.println(car.getModel());
                }
            });
        }
    }
}
