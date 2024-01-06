package Queues;

import LinkedLists.LinkedList;

public class Queue<T> {
    private final LinkedList<T> items;

    public Queue() {
        items = new LinkedList<>();
    }

    public Queue(Iterable<T> initialItems) {
        items = new LinkedList<>(initialItems);
    }

    public T peak() {
        return items.getHead();
    }

    public void enqueue(T item) {
        items.append(item);
    }

    public T dequeue() {
        T item = items.getHead();
        items.deleteHead();
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
