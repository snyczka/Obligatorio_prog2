package adt;

import exeptions.InvalidKey;

public interface HashOb<K, T> {

    public void put(K key, T value);

    public T get(K key);

    public void remove(K key) throws InvalidKey;

    public int size();
}
