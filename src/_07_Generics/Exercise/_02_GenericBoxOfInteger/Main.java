package _07_Generics.Exercise._02_GenericBoxOfInteger;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            Box<Integer> box = new Box<>(number);

            System.out.println(box);
        }
    }
}
