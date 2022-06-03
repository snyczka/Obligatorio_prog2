package adt;

public interface BinarySearchTreeOb<K extends Comparable, T> {

    public void insert(K key, T data);

    public T get(K key);

    public T remove();

    public int size();
}
