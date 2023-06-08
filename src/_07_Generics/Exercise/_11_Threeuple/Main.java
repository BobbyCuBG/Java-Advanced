package _07_Generics.Exercise._11_Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nameAddressTown = sc.nextLine().split("\\s+");
        String name = nameAddressTown[0] + " " + nameAddressTown[1];
        String address = nameAddressTown[2];
        String town = nameAddressTown[3];
        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, town);
        System.out.println(firstThreeuple);

        String[] personBeerDrunk = sc.nextLine().split("\\s+");
        String person = personBeerDrunk[0];
        int litres = Integer.parseInt(personBeerDrunk[1]);
        boolean drunkOrNot = personBeerDrunk[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(person, litres, drunkOrNot);
        System.out.println(secondThreeuple);

        String[] bankInput = sc.nextLine().split("\\s+");
        String bankPerson = bankInput[0];
        double balance = Double.parseDouble(bankInput[1]);
        String bankName = bankInput[2];
        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(bankPerson, balance, bankName);
        System.out.println(thirdThreeuple);
    }
}
