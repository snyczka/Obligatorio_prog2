package adt;

import exeptions.InvalidKey;

public interface HeapOb<K extends Comparable, T> {

    public void insert(K key, T data);

    public T remove(K key) throws InvalidKey;

    public T get(K key);

    public int size();

}
