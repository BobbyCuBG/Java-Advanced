package _07_Generics.Lab.GenericScale;

public class Scale<T extends Comparable<T>> {
    private final T left;
    private final T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    public T getHeavier() {
        if (getLeft().compareTo(getRight()) > 0) {
            return this.left;
        } else if (getLeft().compareTo(getRight()) < 0) {
            return this.right;
        }
        return null;
    }
}
