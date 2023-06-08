package _07_Generics.Exercise._10_Tuple;

public class Tuple<F, S> {
    private final F item1;
    private final S item2;

    public Tuple(F item1, S item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public F getItem1() {
        return item1;
    }



    public S getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", getItem1(), getItem2());
    }
}
