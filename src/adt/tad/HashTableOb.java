package adt.tad;

public class HashTableOb<K, T> implements HashOb<K, T>{
    private static final int initialSize = 10;
    private HashNodeOb<K, T>[] hashArray;
    private float loadFactor = 0.8f;
    private int arraysize = initialSize;
    private K key;
    private T data;

    public HashTableOb(K key, T data){
        this.hashArray = new HashNodeOb[initialSize];
        this.key = key;
        this.data = data;
    }


    @Override
    public void put(K key, T value) {

    }

    @Override
    public T get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }
}
