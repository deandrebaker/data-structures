package Queues;

import LinkedLists.LinkedList;

public class Queue<T> {
    private final LinkedList<T> linkedList;

    public Queue() {
        linkedList = new LinkedList<>();
    }

    public Queue(Iterable<T> initialItems) {
        linkedList = new LinkedList<>(initialItems);
    }

    public T peak() {
        return linkedList.getHead();
    }

    public void enqueue(T item) {
        linkedList.append(item);
    }

    public T dequeue() {
        T item = linkedList.getHead();
        linkedList.deleteHead();
        return item;
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public String toString() {
        return linkedList.toString();
    }
}
