package _07_Generics.Exercise._10_Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nameAndAddress = sc.nextLine().split("\\s+");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        Tuple<String, String> tuple1 = new Tuple<>(name, address);
        System.out.println(tuple1);

        String[] nameAndBeer = sc.nextLine().split("\\s+");
        String secondName = nameAndBeer[0];
        Integer beer = Integer.parseInt(nameAndBeer[1]);
        Tuple<String, Integer> tuple2 = new Tuple<>(secondName, beer);
        System.out.println(tuple2);

        String[] numberAndDouble = sc.nextLine().split("\\s+");
        Integer number = Integer.parseInt(numberAndDouble[0]);
        double dp = Double.parseDouble(numberAndDouble[1]);
        Tuple<Integer, Double> tuple3 = new Tuple<>(number, dp);
        System.out.println(tuple3);
    }
}
