package _07_Generics.Exercise._06_GenericCountMethodDouble;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private final T data;

    public Box(T intData) {

        this.data = intData;
    }

    @Override
    public String toString() {

        return String.format("%s: %s", this.data.getClass().getName(), this.data);
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.data.compareTo(o.data);
    }
}
