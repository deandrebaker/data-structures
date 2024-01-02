package DynamicArrays;

import Arrays.Array;
import Lists.List;

public class DynamicArray<T> implements List<T> {
    private Array<T> array;
    private final int SCALE_FACTOR = 2;

    public DynamicArray() {
        int DEFAULT_CAPACITY = 10;
        array = new Array<>(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        array = new Array<>(capacity);
    }

    public DynamicArray(Iterable<T> initialItems) {
        array = new Array<>(initialItems);
    }

    @Override
    public T lookup(int index) {
        return array.lookup(index);
    }

    @Override
    public int search(T item) {
        return array.search(item);
    }

    @Override
    public void append(T item) {
        if (isFull()) {
            resize(SCALE_FACTOR * getCapacity());
        }
        array.append(item);
    }

    @Override
    public void insert(int index, T item) {
        if (isFull()) {
            resize(SCALE_FACTOR * getCapacity());
        } else if (index > getCapacity()) {
            resize(SCALE_FACTOR * index);
        }
        array.insert(index, item);
    }

    @Override
    public void delete(int index) {
        array.delete(index);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    private boolean isFull() {
        return getSize() == getCapacity();
    }

    public void resize(int capacity) {
        Array<T> newArray = new Array<>(capacity);
        for (int i = 0; i < getSize(); i++) {
            newArray.append(lookup(i));
        }
        array = newArray;
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(lookup(i).toString());
        }
        return String.format("size=%d, items=[%s]", getSize(), sb);
    }
}
