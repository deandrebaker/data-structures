package Stacks;


import DynamicArrays.DynamicArray;

public class Stack<T> {
    private final DynamicArray<T> items;

    public Stack() {
        items = new DynamicArray<>();
    }

    public Stack(Iterable<T> initialItems) {
        items = new DynamicArray<>(initialItems);
    }

    public T peak() {
        return items.lookup(getSize() - 1);
    }

    public void push(T item) {
        items.append(item);
    }

    public T pop() {
        T item = peak();
        items.delete(getSize() - 1);
        return item;
    }

    public int getSize() {
        return items.getSize();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String toString() {
        return items.toString();
    }
}
