package _07_Generics.Exercise._05_GenericCountMethodString;

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

        Box<String> boxToCompare = new Box<>(sc.nextLine());
        compareBoxes(boxes, boxToCompare);
    }

    private static <T extends Comparable<T>> void compareBoxes(List<T> data, T boxToCompare) {
        int counter = 0;
        for (T box : data) {
            if (box.compareTo(boxToCompare) > 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
