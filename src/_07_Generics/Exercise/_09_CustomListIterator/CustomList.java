package _07_Generics.Exercise._09_CustomListIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private final List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        checkValidIndex(index);
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        checkValidIndex(firstIndex);
        checkValidIndex(secondIndex);
        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);

        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        int counter = 0;
        for (T el : this.data) {
            if (el.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new ArrayIndexOutOfBoundsException(String.format("Index %d is out of bound for Size %d.%n", index, this.data.size()));
        }
    }
    public int size() {
        return this.data.size();
    }

    public T get (int index){
        checkValidIndex(index);
        return this.data.get(index);
    }

    public void forEach(Consumer<? super T> action) {
        this.data.forEach(action);
    }
}
