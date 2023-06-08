package _07_Generics.Lab.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> stringScale = new Scale<>(1, 1);
        System.out.println(stringScale.getHeavier());
    }
}
