package _06_DefiningClasses.Lab._02_Constructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int carCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < carCount; i++) {
            String[] carData = sc.nextLine().split("\\s+");

            if (carData.length == 1) {
                Cars car = new Cars(carData[0]);
                System.out.println(car);
            } else {
                String brand = carData[0];
                String model = carData[1];
                int hp = Integer.parseInt(carData[2]);

                Cars car = new Cars(brand, model, hp);
                System.out.println(car);
            }
        }
    }
}
