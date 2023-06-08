package _07_Generics.Exercise._02_GenericBoxOfInteger;

public class Box<T> {
    private final T intData;

    public Box(T intData) {
        this.intData = intData;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.intData.getClass().getName(), this.intData);
    }
}
