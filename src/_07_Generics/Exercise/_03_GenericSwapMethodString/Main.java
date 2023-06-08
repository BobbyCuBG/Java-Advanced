package _07_Generics.Exercise._03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<Box<String>> boxes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<>(sc.nextLine());
            boxes.add(box);
        }

        String[] indexes = sc.nextLine().split("\\s+");

        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);

        swap(boxes, firstIndex, secondIndex);

        boxes.forEach(System.out::println);
    }

    private static <T> void swap(List<T> boxes, int firstIndex, int secondIndex) {

        T firstElement = boxes.get(firstIndex);
        T secondElement = boxes.get(secondIndex);

        boxes.set(firstIndex, secondElement);
        boxes.set(secondIndex, firstElement);
    }
}
