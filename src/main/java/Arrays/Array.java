package Arrays;

public class Array<T> {
    private final Object[] items;
    private final int capacity;
    private int size;

    public Array(int capacity) {
        items = new Object[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public Array(Iterable<T> initialItems) {
        int capacity = 0;
        for (T ignored : initialItems) {
            capacity++;
        }
        items = new Object[capacity];
        size = 0;
        this.capacity = capacity;
        for (T item : initialItems) {
            items[size++] = item;
        }
    }

    public T lookup(int index) {
        if (index < 0 || index >= size) throw new RuntimeException("Could not lookup. Index out of range.");

        //noinspection unchecked
        return (T) items[index];
    }

    public int search(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public void append(T item) {
        if (isFull()) throw new RuntimeException("Could not append. Array is full.");

        items[size++] = item;
    }

    public void insert(int index, T item) {
        if (isFull()) throw new RuntimeException("Could not insert. Array is full.");
        if (index < 0 || index > size) throw new RuntimeException("Could not insert. Index out of range.");

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
    }

    public void delete(int index) {
        if (isEmpty()) throw new RuntimeException("Could not delete. Array is empty.");
        if (index < 0 || index >= size) throw new RuntimeException("Could not delete. Index out of range.");

        size--;
        for (int i = index; i < size; i++) {
            items[i] = items[i + 1];
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(items[i].toString());
        }
        return String.format("size=%d, capacity=%d, items=[%s]", size, capacity, sb);
    }
}
