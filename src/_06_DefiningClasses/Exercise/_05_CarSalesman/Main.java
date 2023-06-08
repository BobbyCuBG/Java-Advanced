package _06_DefiningClasses.Exercise._05_CarSalesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine());
            List<Engine> engineList = new ArrayList<>();
            Map<String, Engine> engineMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] tokens = sc.nextLine().split("\\s+");
                String engineModel = tokens[0];
                int enginePower = Integer.parseInt(tokens[1]);

                if (tokens.length == 2) {
                    addEngineToEngineList(engineList, engineMap, engineModel, enginePower);
                } else if (tokens.length == 3) {
                    if (isNumber(tokens[2])) {
                        int engineDisplacement = Integer.parseInt(tokens[2]);
                        addEngineToEngineList(engineList, engineMap, engineModel, enginePower, engineDisplacement);
                    } else {
                        String engineEfficiency = tokens[2];
                        addEngineToEngineList(engineList, engineMap, engineModel, enginePower, engineEfficiency);
                    }
                } else {
                    int engineDisplacement = Integer.parseInt(tokens[2]);
                    String engineEfficiency = tokens[3];
                    addEngineToEngineList(engineList, engineMap, engineModel, enginePower, engineDisplacement, engineEfficiency);
                }
            }

            List<Car> carList = new ArrayList<>();

            int m = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < m; i++) {
                String[] tokens = sc.nextLine().split("\\s+");
                String carModel = tokens[0];
                String engineModel = tokens[1];

                if (tokens.length == 2) {
                    createCarAndPutInList(carList, engineMap, carModel, engineModel);
                } else if (tokens.length == 3) {
                    if (isNumber(tokens[2])) {
                        int carWeight = Integer.parseInt(tokens[2]);
                        createCarAndPutInList(carList, engineMap, carModel, engineModel, carWeight);
                    } else {
                        String color = tokens[2];
                        createCarAndPutInList(carList, engineMap, carModel, engineModel, color);
                    }
                } else {
                    int carWeight = Integer.parseInt(tokens[2]);
                    String color = tokens[3];
                    createCarAndPutInList(carList, engineMap, carModel, engineModel, carWeight, color);
                }
            }

            carList.forEach(System.out::println);
        }
    }

    private static void createCarAndPutInList(List<Car> carList, Map<String, Engine> engineMap, String carModel, String engineModel) {
        Engine engine = engineMap.get(engineModel);
        if (engine != null) {
            Car car = new Car(carModel, engine);
            carList.add(car);
        }
    }

    private static void createCarAndPutInList(List<Car> carList, Map<String, Engine> engineMap, String carModel, String engineModel, String color) {
        Engine engine = engineMap.get(engineModel);
        if (engine != null) {
            Car car = new Car(carModel, engine, color);
            carList.add(car);
        }
    }

    private static void createCarAndPutInList(List<Car> carList, Map<String, Engine> engineMap, String carModel, String engineModel, int carWeight) {
        Engine engine = engineMap.get(engineModel);
        if (engine != null) {
            Car car = new Car(carModel, engine, carWeight);
            carList.add(car);
        }
    }

    private static void createCarAndPutInList(List<Car> carList, Map<String, Engine> engineMap, String carModel, String engineModel, int carWeight, String color) {
        Engine engine = engineMap.get(engineModel);
        if (engine != null) {
            Car car = new Car(carModel, engine, carWeight, color);
            carList.add(car);
        }
    }

    private static void addEngineToEngineList(List<Engine> engineList, Map<String, Engine> engineMap, String engineModel, int enginePower) {
        Engine engine = new Engine(engineModel, enginePower);
        engineList.add(engine);
        engineMap.put(engineModel, engine);
    }

    private static void addEngineToEngineList(List<Engine> engineList, Map<String, Engine> engineMap, String engineModel, int enginePower, String engineEfficiency) {
        Engine engine = new Engine(engineModel, enginePower, engineEfficiency);
        engineList.add(engine);
        engineMap.put(engineModel, engine);
    }

    private static void addEngineToEngineList(List<Engine> engineList, Map<String, Engine> engineMap, String engineModel, int enginePower, int engineDisplacement) {
        Engine engine = new Engine(engineModel, enginePower, engineDisplacement);
        engineList.add(engine);
        engineMap.put(engineModel, engine);
    }

    private static void addEngineToEngineList(List<Engine> engineList, Map<String, Engine> engineMap, String engineModel, int enginePower, int engineDisplacement, String engineEfficiency) {
        Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
        engineList.add(engine);
        engineMap.put(engineModel, engine);
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
