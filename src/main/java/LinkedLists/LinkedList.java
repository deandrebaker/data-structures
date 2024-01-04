package LinkedLists;

import Lists.List;

class Node<T> {
    T value;
    Node<T> previous;
    Node<T> next;

    public Node(T value, Node<T> previous, Node<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public LinkedList(Iterable<T> initialItems) {
        this();
        for (T item : initialItems) {
            append(item);
        }
    }

    public T getHead() {
        if (isEmpty()) throw new RuntimeException("Could not lookup. No items.");

        return head.value;
    }

    public T getTail() {
        if (isEmpty()) throw new RuntimeException("Could not lookup. No items.");

        return tail.value;
    }

    private Node<T> getNode(int index) {
        Node<T> node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.previous;
            }
        }
        return node;
    }

    @Override
    public T lookup(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Could not lookup. Index out of range.");

        return getNode(index).value;
    }

    @Override
    public int search(T item) {
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(item)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public void prepend(T item) {
        if (isEmpty()) {
            head = tail = new Node<>(item, null, null);
        } else {
            head.previous = new Node<>(item, null, head);
            head = head.previous;
        }
        size++;
    }

    @Override
    public void append(T item) {
        if (isEmpty()) {
            head = tail = new Node<>(item, null, null);
        } else {
            tail.next = new Node<>(item, tail, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void insert(int index, T item) {
        if (index < 0) throw new RuntimeException("Could not insert. Index out of range.");

        else if (index > size) {
            for (int i = size; i < index; i++) {
                append(null);
            }
            append(item);
        } else if (index == 0) {
            prepend(item);
        } else if (index == size) {
            append(item);
        } else {
            Node<T> next = getNode(index);
            Node<T> previous = next.previous;
            Node<T> node = new Node<>(item, previous, next);
            previous.next = node;
            next.previous = node;
            size++;
        }
    }

    public void deleteHead() {
        if (isEmpty()) throw new RuntimeException("Could not delete. No items.");

        head = head.next;
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    public void deleteTail() {
        if (isEmpty()) throw new RuntimeException("Could not delete. No items.");

        tail = tail.previous;
        size--;
        if (size == 0) {
            head = null;
        }
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Could not insert. Index out of range.");
        if (index == 0) {
            deleteHead();
        } else if (index == size - 1) {
            deleteTail();
        } else {
            if (isEmpty()) throw new RuntimeException("Could not delete. No items.");

            Node<T> node = getNode(index);
            Node<T> previous = node.previous;
            Node<T> next = node.next;
            previous.next = next;
            next.previous = previous;
            size--;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            sb.append(node.value.toString());
            node = node.next;
        }
        return String.format("size=%d, items=[%s]", getSize(), sb);
    }
}
