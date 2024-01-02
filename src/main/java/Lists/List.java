package Lists;

public interface List<T> {
    T lookup(int index);

    int search(T item);

    void append(T item);

    void insert(int index, T item);

    void delete(int index);

    int getSize();

    boolean isEmpty();

    String toString();
}
