package _06_DefiningClasses.Lab._01_CarInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int carCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < carCount; i++) {
            String input = sc.nextLine();

            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int hp = Integer.parseInt(input.split("\\s+")[2]);

            Car car = new Car(brand, model, hp);
            System.out.println(car);
        }
    }
}
